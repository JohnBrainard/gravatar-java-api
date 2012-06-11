/**
 * Copyright 2012 John Brainard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.brainardphotography.gravatar;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.io.ByteStreams;

/**
 * This is an abstract class providing common functionality for 
 * {@link GravatarProfileURL} and {@link GravatarImageURL}.
 * 
 * <ul>
 * <li>Refer to {@link GravatarImageURL} for functionality related to Gravatar images.</li>
 * <li>Refer to {@link GravatarProfileURL} for functionality related to Gravatar profiles.</li>
 * </ul>
 * 
 * @author John Brainard
 */
public abstract class GravatarURL {
	private static final Logger logger = Logger.getLogger(GravatarURL.class.getName());
	private static MessageDigest md5;
	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			logger.log(Level.SEVERE, "Unable to get MD5 instance.", ex);
		}
	}

	private final String email;
	private boolean secure = false;

	protected GravatarURL(String email) {
		this.email = email;
	}

	/**
	 * Determines whether or not the request should be made over 
	 * HTTPS or standard HTTP.
	 * 
	 * <p><b>Default</b>: <code>true</code></p>
	 */
	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public boolean isSecure() {
		return secure;
	}

	/**
	 * Retrieve list of set parameters from inherited class.
	 * 
	 * @return List of {@link Optional} containing {@link GravatarParameters}.
	 */
	protected abstract GravatarParameters getParameters();
	
	/**
	 * Retrieve the base path used to construct the Gravatar URL.
	 */
	protected abstract String getBasePath();

	public final String getEmail() {
		return email;
	}
	
	public String getEmailHash() {
		return getEmailHash(this.email);
	}
	
	/**
	 * Returns the email hash according to <a href="https://en.gravatar.com/site/implement/hash/">'Creating the hash'</a>
	 */
	public static String getEmailHash(String email) {
		byte[] hash = md5.digest(email.trim().toLowerCase().getBytes());
		return new BigInteger(hash).toString(16);
	}

	/**
	 * Returns a string representation of this {@link GravatarURL}.
	 * 
	 * @see <a href="https://en.gravatar.com/site/implement/">Gravatar Developer Resources</a>
	 */
	@Override
	public String toString() {
		return Joiner.on("?").skipNulls().join(new String[] {
				getBaseURL(),
				getQueryString()
		});
	}

	protected String getBaseURL() {
		String formatString = secure ?
				"https://secure.gravatar.com/%s%s" :
				"http://www.gravatar.com/%s%s";

		return String.format(formatString,
				getBasePath(),
				getEmailHash());
	}

	/**
	 * Returns the portion of the URL after '?'.
	 * 
	 * @return Concatenated list of parameters joined by '&' or null
	 * if there are no parameters.
	 */
	public String getQueryString() {
		Iterable<Optional<GravatarParameter>> params = getParameters().getNonEmptyParams();

		Joiner paramJoiner = Joiner.on("=");
		StringBuilder queryString = new StringBuilder();

		for (Optional<GravatarParameter> param : params) {
			if (queryString.length() > 0)
				queryString.append("&");

			queryString.append(paramJoiner.join(
					param.get().getKey(),
					param.get().getValue()));
		}

		return queryString.length() == 0 ? null : queryString.toString();
	}

	/**
	 * Returns a {@link URL} representation of this {@link GravatarURL}
	 */
	public URL toURL() {
		try {
			return new URL(this.toString());
		} catch (MalformedURLException ex) {
			// This shouldn't ever happen... If it does, it's a bug in the GravatarURL code
			// that needs to be reported.
			throw new RuntimeException("This is a fatal bug... Please report to the developer.", ex);
		}
	}

	/**
	 * Fetch the byte data for the Gravatar data.
	 * 
	 * @throws IOException
	 */
	public byte[] getBytes() throws IOException {
		URL url = toURL();

		try (InputStream stream = url.openStream();)
		{
			return ByteStreams.toByteArray(stream);
		}
	}

	/**
	 * Returns the input stream to retrieve the Gravatar image contents.
	 * 
	 * @throws IOException
	 */
	public InputStream openStream() throws IOException {
		URL url = toURL();

		return url.openStream();
	}

}

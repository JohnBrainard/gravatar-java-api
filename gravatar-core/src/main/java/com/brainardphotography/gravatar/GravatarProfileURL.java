/*
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
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.brainardphotography.gravatar.GravatarProfileFormat.ContentType;
import com.brainardphotography.gravatar.contact.ContactLoader;
import com.brainardphotography.gravatar.contact.PCContact;
import com.brainardphotography.gravatar.contact.PCContactLoader;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;

public class GravatarProfileURL extends GravatarURL {
	private Optional<GravatarParameter> size = Optional.absent();

	public GravatarProfileURL(String email) {
		super(email);
	}

	public void setSize(Integer size) {
		Preconditions.checkNotNull(size, "'size' cannot be null");

		this.size = Optional.of(new GravatarParameter("s", size.toString()));
	}
	
	public String getText(GravatarProfileFormat format) throws IOException {
		if (format.getContentType() == ContentType.BINARY)
			throw new IllegalArgumentException("'getAsText' doesn't support BINARY content types.");

		URL url = toURL(format);
		
		try (InputStream input = url.openStream()) {
			return CharStreams.toString(new InputStreamReader(input));
		}
	}

	public PCContact getContact() throws IOException {
		URL url = toURL(GravatarProfileFormat.JSON);
		ContactLoader loader = PCContactLoader.getInstance();

		try (InputStream input = url.openStream()) {
			return loader.loadContact(new InputStreamReader(input));
		}
	}

	public byte[] getBytes(GravatarProfileFormat format) throws IOException {
		URL url = toURL(format);

		try(InputStream input = url.openStream()) {
			return ByteStreams.toByteArray(input);
		}
	}
	
	public String toString(GravatarProfileFormat format) {
		return Joiner.on("?").skipNulls().join(new String[] {
				getBaseURL() + format.getExtension(),
				getQueryString()
		});
	}

	public URL toURL(GravatarProfileFormat format) {
		try {
			return new URL(toString(format));
		} catch (MalformedURLException ex) {
			// This shouldn't ever happen... If it does, it's a bug in the GravatarURL code
			// that needs to be reported.
			throw new RuntimeException("This is a fatal bug... Please report to the developer.", ex);
		}
	}

	@Override
	protected GravatarParameters getParameters() {
		return new GravatarParameters() {
			private static final long serialVersionUID = -3089034189638251230L;

			{
				add(size);
			}
		};
	}

	@Override
	protected String getBasePath() {
		return "";
	}
}

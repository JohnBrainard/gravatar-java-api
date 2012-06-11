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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GravatarTestUtils {
	private static final Logger logger = Logger.getLogger(GravatarTestUtils.class.getName());

	static MessageDigest md5;
	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			logger.log(Level.SEVERE, "Unable to get MD5 instance.", ex);
		}
	}
	
	static String getEmailHash(String email) {
		byte[] hash = md5.digest(email.trim().toLowerCase().getBytes());
		
		return new BigInteger(hash).toString(16);
	}


}

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

import static org.junit.Assert.*;
import static com.brainardphotography.gravatar.GravatarTestUtils.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class TestGravatarProfileURL {
	private static final Logger logger = Logger.getLogger(TestGravatarProfileURL.class.getName());

	@Test
	public void testSimpleURL() {
		final String hash = getEmailHash("test@test.com");
		final String expected = "http://www.gravatar.com/" + hash;

		GravatarURL gravatarURL = new GravatarProfileURL("test@test.com");
		String toString = gravatarURL.toString();
		assertEquals(expected, toString);
	}

	@Test
	public void testGetProfileText() throws IOException {
		GravatarProfileURL gravatarURL = new GravatarProfileURL("jfbrainard@gmail.com");
		String url = gravatarURL.toString(GravatarProfileFormat.DEFAULT);
		String toString = gravatarURL.getAsText(GravatarProfileFormat.DEFAULT);

		assertNotNull(toString);

		logger.log(Level.INFO, url);
		logger.log(Level.INFO, toString);
	}

	@Test
	public void testGetProfileJSON() throws IOException {
		GravatarProfileURL gravatarURL = new GravatarProfileURL("jfbrainard@gmail.com");
		String url = gravatarURL.toString(GravatarProfileFormat.JSON);
		String toString = gravatarURL.getAsText(GravatarProfileFormat.JSON);

		assertNotNull(toString);

		logger.log(Level.INFO, url);
		logger.log(Level.INFO, toString);
	}

	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testGetProfileQRCodeAsText() throws IOException {
		GravatarProfileURL gravatarURL = new GravatarProfileURL("jfbrainard@gmail.com");
		String url = gravatarURL.toString(GravatarProfileFormat.QR_CODE);
		String toString = gravatarURL.getAsText(GravatarProfileFormat.QR_CODE);

		assertNull(toString);
	}
}

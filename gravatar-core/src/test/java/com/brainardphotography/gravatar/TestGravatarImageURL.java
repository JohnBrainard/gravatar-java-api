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

public class TestGravatarImageURL {
	private static final Logger logger = Logger.getLogger(TestGravatarImageURL.class.getName());

	@Test
	public void testSimpleURL() {
		final String hash = getEmailHash("test@test.com");
		final String expected = "http://www.gravatar.com/avatar/" + hash;

		GravatarURL gravatarURL = new GravatarImageURL("test@test.com");
		String toString = gravatarURL.toString();
		assertEquals(expected, toString);
	}

	@Test
	public void testWithSizeParam() {
		final String hash = getEmailHash("test@test.com");
		final String expected = "http://www.gravatar.com/avatar/" + hash + "?s=200";

		GravatarURL gravatarURL = new GravatarImageURL("test@test.com")
			.setSize(200);
		
		String toString = gravatarURL.toString();
		assertEquals(expected, toString);
	}

	@Test
	public void testWithDefaultImageParam() {
		final String hash = getEmailHash("test@test.com");
		final String expected = "http://www.gravatar.com/avatar/" + hash + "?d=http%3A%2F%2Fexample.com%2Fimages%2Favatar.jpg";

		GravatarURL gravatarURL = new GravatarImageURL("test@test.com")
			.setDefaultImage("http://example.com/images/avatar.jpg");

		String toString = gravatarURL.toString();
		assertEquals(expected, toString);
	}

	@Test
	public void testWithRatingParam() {
		final String hash = getEmailHash("test@test.com");
		final String expected = "http://www.gravatar.com/avatar/" + hash + "?r=pg";

		GravatarURL gravatarURL = new GravatarImageURL("test@test.com")
			.setRating(GravatarRating.PG);

		String toString = gravatarURL.toString();
		assertEquals(expected, toString);
	}
	
	@Test
	public void testGetBytes() throws IOException {
		GravatarImageURL url = new GravatarImageURL("test@test.com");

		byte[] bytes = url.getBytes();

		assertNotNull(bytes);
		assertTrue(bytes.length > 0);
		
		logger.log(Level.INFO, "getBytes returned " + bytes.length + " bytes.");
	}
}

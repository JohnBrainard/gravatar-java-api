package com.brainardphotography.gravatar.contact;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestContactLoader {
	private static final String SAMPLE_FILE_NAME = "sample-portable-contact.json";

	/**
	 * This test verifies that the loader is loading the JSON file without issues.
	 * The data has been visually inspected for completeness. Complete tests will
	 * be written as needed.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testContactLoader() throws IOException {
		ContactLoader contactLoader = PCContactLoader.getInstance();
		
		try (InputStream in = loadTestFile()) {
			PCContact contact = contactLoader.loadContact(new InputStreamReader(in));
			
			assertNotNull(contact);
		}
	}
	
	private InputStream loadTestFile() throws IOException {
		InputStream in = getClass().getClassLoader().getResourceAsStream(SAMPLE_FILE_NAME);
		
		return in;
	}
}

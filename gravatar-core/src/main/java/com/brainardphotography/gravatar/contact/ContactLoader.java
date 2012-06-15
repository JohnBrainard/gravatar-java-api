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
package com.brainardphotography.gravatar.contact;

import java.io.IOException;
import java.io.Reader;

/**
 * Defines an interface for a contact loader that loads Portable Contact data.
 * For now, the only implementation is {@link PCContactLoader} which loads from
 * a JSON source.
 * 
 * <p>Refer to <a href="http://portablecontacts.net/draft-spec.html">Portable Contacts 1.0 Draft C</a></p>
 *
 * @author John Brainard
 */
public interface ContactLoader {
	
	/**
	 * Load a contact from the provided Reader.
	 * 
	 * @return New {@link PCContact} instance if found, else <code>null</code>
	 * @throws IOException Passed through from the Reader.
	 */
	public PCContact loadContact(Reader reader) throws IOException;
}

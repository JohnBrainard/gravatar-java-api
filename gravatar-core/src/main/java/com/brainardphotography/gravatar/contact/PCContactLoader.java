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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PCContactLoader implements ContactLoader {
	private static ContactLoader instance = null;

	private Gson gson;
	private JsonParser jsonParser;

	private PCContactLoader() {
		gson = new Gson();
		jsonParser = new JsonParser();
	}

	public static ContactLoader getInstance() {
		if (instance == null)
			instance = new PCContactLoader();

		return instance;
	}

	@Override
	public PCContact loadContact(Reader reader) throws IOException {
		JsonElement element = jsonParser.parse(reader);
		JsonObject object = element.getAsJsonObject();
		JsonArray entries = object.getAsJsonArray("entry");

		if (entries.size() > 0)
			return gson.fromJson(entries.get(0), PCContact.class);

		return null;
	}	
}

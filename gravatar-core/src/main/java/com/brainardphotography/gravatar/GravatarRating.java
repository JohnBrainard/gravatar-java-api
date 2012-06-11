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

public enum GravatarRating {
	/**
	 * Suitable for display on all websites with any audience type.
	 */
	G("g"),
	
	/**
	 * May contain rude gestures, provocatively dressed individuals, 
	 * the lesser swear words, or mild violence.
	 */
	PG("pg"),
	
	/**
	 * May contain such things as harsh profanity, intense violence, 
	 * nudity, or hard drug use.
	 */
	R("r"),
	
	/**
	 * May contain hardcore sexual imagery or extremely disturbing violence.
	 */
	X("x");

	private String value;

	private GravatarRating(String value) {
		this.value = value;
	}

	String getValue() {
		return value;
	}
}

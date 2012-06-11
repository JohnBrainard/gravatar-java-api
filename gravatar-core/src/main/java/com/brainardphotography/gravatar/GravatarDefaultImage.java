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

/**
 * Gravatar supports a variety of preset default images, some of which
 * are randomly generated. See comments on individual entries below.
 * 
 * <p><a href="https://en.gravatar.com/site/implement/images/">Gravatar Images</a></p>
 * @author John Brainard
 */
public enum GravatarDefaultImage {
	/**
	 * Do not load any image if none is associated with the email hash, 
	 * instead return an HTTP 404 (File Not Found) response
	 */
	NotFound("404"),
	
	/**
	 * A simple, cartoon-style silhouetted outline of a 
	 * person (does not vary by email hash)
	 */
	MysteryMan("mm"),
	
	/**
	 * A geometric pattern based on an email hash
	 */
	EmailHashPattern("identicon"),

	/**
	 * A generated 'monster' with different colors, faces, etc
	 */
	RandomMonster("monsterid"),

	/**
	 * Generated faces with differing features and backgrounds
	 */
	RandomFaces("wavatar"),

	/**
	 * Awesome generated, 8-bit arcade-style pixelated faces
	 */
	Retro("retro");

	private final String code;
	GravatarDefaultImage(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}

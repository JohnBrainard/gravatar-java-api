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

public enum GravatarProfileFormat {
	DEFAULT(""),
	JSON(".json"),
	XML(".xml"),
	PHP(".php"),
	VCF(".vcf"),
	QR_CODE(".qr", ContentType.BINARY);

	enum ContentType {
		BINARY,
		TEXT
	}

	private ContentType contentType;
	private String extension;

	GravatarProfileFormat(String extension) {
		this(extension, ContentType.TEXT);
	}

	private GravatarProfileFormat(String extension, ContentType contentType) {
		this.extension = extension;
		this.contentType = contentType;
	}
	
	public ContentType getContentType() {
		return contentType;
	}
	
	public String getExtension() {
		return extension;
	}
}

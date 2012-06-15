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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.EnumSet;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Provides facilities to generate Gravatar URLs and for downloading
 * Gravatar images.
 * 
 * @author John Brainard
 *
 */
public class GravatarImageURL extends GravatarURL {
	public static final String BASE_PATH = "avatar/";

	private Optional<GravatarParameter> size = Optional.absent();
	private Optional<GravatarParameter> defaultImage = Optional.absent();
	private Optional<GravatarParameter> forceDefault = Optional.absent();

	private EnumSet<GravatarRating> ratings;

	/**
	 * Constructs a new Gravatar Image URL. This is enough to construct a
	 * basic Gravatar Image URL.
	 * 
	 * @param email
	 */
	public GravatarImageURL(String email) {
		super(email);
	}

	public GravatarImageURL(String email, Integer size, String defaultImage, Boolean forceDefault, EnumSet<GravatarRating> ratings) {
		this (email);
		
		if (size != null)
			setSize(size);
		
		if (defaultImage != null)
			setDefaultImage(defaultImage);
		
		if (forceDefault != null)
			setForceDefault(forceDefault);
		
		if (ratings != null)
			this.ratings = ratings;
	}

	public GravatarImageURL setSize(Integer size) {
		Preconditions.checkNotNull(size, "'size' cannot be null.");

		this.size = Optional.of(new GravatarParameter("s", size.toString()));
		return this;
	}
	
	public GravatarImageURL setDefaultImage(String defaultImage) {
		Preconditions.checkNotNull(defaultImage, "'defaultImage' cannot be null.");

		try {
			this.defaultImage = Optional.of(new GravatarParameter("d", 
					URLEncoder.encode(defaultImage, "UTF-8")));
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("There seems to be a bug in the software.", ex);
		}

		return this;
	}
	
	public GravatarImageURL setDefaultImage(GravatarDefaultImage defaultImage) {
		return setDefaultImage(defaultImage.getCode());
	}
	
	public GravatarImageURL setForceDefault(Boolean forceDefault) {
		Preconditions.checkNotNull(forceDefault);
		this.forceDefault = Optional.of(new GravatarParameter("f", forceDefault.toString()));

		return this;
	}

	/**
	 * Set a single content rating restriction.
	 * {@link GravatarRating}
	 * @param rating
	 */
	public GravatarImageURL setRating(GravatarRating rating) {
		ratings = EnumSet.of(rating);
		
		return this;
	}

	/**
	 * Set multiple content rating restrictions.
	 * 
	 * {@link GravatarRating}
	 */
	public GravatarImageURL setRating(GravatarRating rating, GravatarRating... more) {
		ratings = EnumSet.of(rating, more);
		
		return this;
	}

	@Override
	protected GravatarParameters getParameters() {
		return new GravatarParameters() {
			private static final long serialVersionUID = 1L;

			{
				add(size);
				add(defaultImage);
				add(forceDefault);

				if (ratings != null) {
					for (GravatarRating rating : ratings) {
						add(Optional.of(new GravatarParameter("r", rating.getValue())));
					}
				}
			}
		};
	}

	@Override
	protected String getBasePath() {
		return BASE_PATH;
	}

}

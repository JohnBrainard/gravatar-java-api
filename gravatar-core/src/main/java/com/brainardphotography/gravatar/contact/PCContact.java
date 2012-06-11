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
package com.brainardphotography.gravatar.contact;

import java.util.List;

public class PCContact {
	private String id;
	private String hash;
	private String requestHash;
	private String profileUrl;
	private String thumbnailUrl;
	private String preferredUsername;
	private String displayName;
	private String aboutMe;
	private String currentLocation;
	private PCName name;
	private String birthday;
	private String gender;
	private List<String> tags;
	private List<PCEmail> emails;
	private List<PCUrl> urls;
	private List<PCPhoneNumber> phoneNumbers;
	private List<PCPhoto> photos;
	private List<PCInstantMessengerAccount> ims;
	private List<PCAddress> addresses;
	private List<PCOrganization> organizations;
	private List<PCAccount> accounts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getRequestHash() {
		return requestHash;
	}

	public void setRequestHash(String requestHash) {
		this.requestHash = requestHash;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getPreferredUsername() {
		return preferredUsername;
	}

	public void setPreferredUsername(String preferredUsername) {
		this.preferredUsername = preferredUsername;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public PCName getName() {
		return name;
	}

	public void setName(PCName name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<PCEmail> getEmails() {
		return emails;
	}

	public void setEmails(List<PCEmail> emails) {
		this.emails = emails;
	}

	public List<PCUrl> getUrls() {
		return urls;
	}

	public void setUrls(List<PCUrl> urls) {
		this.urls = urls;
	}

	public List<PCPhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PCPhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<PCPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PCPhoto> photos) {
		this.photos = photos;
	}

	public List<PCInstantMessengerAccount> getIms() {
		return ims;
	}

	public void setIms(List<PCInstantMessengerAccount> ims) {
		this.ims = ims;
	}

	public List<PCAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<PCAddress> addresses) {
		this.addresses = addresses;
	}

	public List<PCOrganization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<PCOrganization> organizations) {
		this.organizations = organizations;
	}

	public List<PCAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<PCAccount> accounts) {
		this.accounts = accounts;
	}

}

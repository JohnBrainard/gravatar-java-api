Gravatar Java API
=================

The _Gravatar Java API_ is a simple wrapper around the Gravatar image and profile
URLs. The goal is to implement a complete Java API then add J2EE support.

Sample Usage
------------

_Generate Gravatar Image URL_

	GravatarURL gravatarURL = new GravatarImageURL("test@test.com");

	gravatarURL.setDefaultImage(GravatarDefaultImage.RandomMonster);
	gravatarURL.setSize(100);

	String toString = gravatarURL.toString();

_Retrieve Image as Byte Array_
	
	try {
		gravatarURL.getBytes() // Throws IOException
	} catch (IOException ex) {
		// Handle exception...
	}

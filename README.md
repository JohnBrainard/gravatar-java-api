Gravatar Java API
=================

The _Gravatar Java API_ is a simple wrapper around the Gravatar image and profile
URLs. The goal is to implement a complete Java API then add J2EE support.

Sample Usage
------------

### Generate Gravatar Image URL

	GravatarURL gravatarURL = new GravatarImageURL("test@test.com");

	gravatarURL.setDefaultImage(GravatarDefaultImage.RandomMonster);
	gravatarURL.setSize(100);

	String toString = gravatarURL.toString();

### Retrieve Image as Byte Array
	
	try {
		gravatarURL.getBytes() // Throws IOException
	} catch (IOException ex) {
		// Handle exception...
	}

### Want profile info as native Java Objects?

The following example loads the profile JSON and parses it using the
Gson parser, all of which is transparent to you. You can just as easily
use `PCContactLoader.getLoader().loadContact(Reader)` to load from a JSON
source outside of Gravatar.

	GravatarProfileURL profile = new GravatarProfileURL("test@test.com");

	PCContact contact = profile.getContact();

In order to run the above code, ensure that the Gson library is on your
classpath. To keep the _Gravatar Java API_ ligthweight, the
maven dependency for the Gson library is required only at compile time
so that you're not forced to load a library you don't need if all you
care to do is generate URLs or parse the JSON or XML data yourself.

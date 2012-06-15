<%@taglib uri="http://www.brainardphotography.com/gravatar/jsp" prefix="gravatar"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<h2>Hello World!</h2>

	<gravatar:image email="jfbrainard@gmail.com">
		<img src="${gravatar}" />
	</gravatar:image>

	<gravatar:image email="test@test.com" rating="G, pg, R" size="200" defaultImage="identicon">
		<img src="${gravatar}" />
	</gravatar:image>
</body>
</html>

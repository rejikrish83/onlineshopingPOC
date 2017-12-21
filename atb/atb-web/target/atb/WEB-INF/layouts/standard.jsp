<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>All is to buy</title>
	<link rel="stylesheet" href="<c:url value="/resources/styles/gtmt.css" />" type="text/css" media="screen" />
	<link rel="stylesheet" href="<c:url value="/resources/styles/screen.css" />" type="text/css" media="screen, projection" />
	<link rel="stylesheet" href="<c:url value="/resources/styles/print.css" />" type="text/css" media="print" />
</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="topbar">
			<p align="right"><a href="<c:url value="/" />">Login</a></p>
		</div>
		<div id="logo">
			<p>
				<a href="<c:url value="/" />">
					<img src="<c:url value="/resources/images/header.jpg"/>" height="200" width="950"/>
				</a>
			</p>
		</div>
	</div>
	<div id="content">
		<div id="main" class="span-18 last">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="local" class="span-6">
			<p>
				<img src="<c:url value="/resources/images/diplomat.jpg"/>" height="250" width="200" align="right"/>
			</p>
		</div>
	</div>
	<hr />
	<div id="footer">
		<a href="<c:url value="/" />">
			<img src="<c:url value="/resources/images/footer.jpg"/>" height="25" width="950" />
		</a> 
	</div>
</div>
</body>
</html>
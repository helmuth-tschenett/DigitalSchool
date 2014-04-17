<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Digitale Schule 2.0</title>
	<link href="css/cupertino/jquery-ui-1.10.4.custom.css" rel="stylesheet">	
	<link href="digitalschool.css" rel="stylesheet">	
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
	<script src="digitalschool.js"></script>
 	<script>
	$(function() {
		$( "#main" ).tabs();
		$( "#stundenplan" ).accordion({ heightStyle: "content", collapsible: true, active: false });
	});
	</script>
	<jsp:useBean id="ds" scope="session" class="com.oss.tfo.DigitalSchool"></jsp:useBean>
</head>
<body>
<h1> Digitale Schule: by 5A GOB-Schlanders 2013/2014</h1>
<div id="main">
<ul>
<li><a href="#tabs-1">Schulräume</a></li>
<li><a href="#tabs-2">Klassen</a></li>
<li><a href="#tabs-3">Schüler</a></li>
<li><a href="#tabs-4">Fächer</a></li>
<li><a href="#tabs-5">Stundeneinteilung</a></li>
<li><a href="#tabs-6">Stundenplan</a></li>
<li><a href="#tabs-7">Tages-Register</a></li>
<li><a href="#tabs-8">Noten</a></li>
</ul>
<div id="tabs-1">
<p>Schulräume
</div>
<div id="tabs-2">
<p>Klassen
</div>
<div id="tabs-3">
<p>Schüler
</div>
<div id="tabs-4">
<p>Fächer
</div>
<div id="tabs-5">
<p>Stundeneinteilung
</div>
<div id="tabs-6">
<div id="stundenplan">
<%= ds.getStundenpläneAsHtmlTable() %>
</div>
</div>
<div id="tabs-7">
<p>Tagesregister
</div>
<div id="tabs-8">
<p>Noten
</div>
</div>

</body>
</html>
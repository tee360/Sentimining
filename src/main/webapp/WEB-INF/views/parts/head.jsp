<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%--
	On this page the user can choose to view movies or categories.
	
	Model: none
 --%>
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet”
	type=”text/css” />
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
<html lang="en">
<head>

<link href=<c:url value="resources/bootstrap/css/bootstrap.css"/> rel="stylesheet">
<link href=<c:url value="resources/Main.css"/> rel="stylesheet">
<!-- meta charset "utf-8" -->
<title>Reflect</title>
<style>
body {
	background: url: 
	margin: 0;
	padding: 0;
	font-family: "Helvetica", "Arial";
}

#wrapper {
	width: 960px height: auto;
	background: #00ff00 border-left: 5px solid border-right: 5px solid
		overflow: auto;
	margin: 0 auto;
	padding: 10px
}

#header {
	width: 100% height: 100px border-bottom: 3px solid #7c7063;
}

#logo {
	float: left margin: 30px 0px 0px 90px;
}

#social ul li {
	float: left;
	list-style: none;
	padding-right: 5px
}

#social img {
	height: 55px;
	width: 55px;
}
</style>
</head>


<html>
<head>
<%@ include file="parts/head.jsp"%>
<title>Home</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<a name="top"></a>
			<div id="logo">
				<img src="http://reflect.ws/img/startPage_reflective_logo.png"
					width="350" height="80" alt="logo" title=Reflect />
			</div>
			<!-- end of logo --><div id="social">
	<ul>
		<li><a href="http://www.twitter.com" target="_blank"><img
				src="https://d13yacurqjgara.cloudfront.net/users/31260/screenshots/765813/attachments/75674/twitter-icon.png"
				alt="twitter" title="twitter" /></a></li>
	</ul>
</div>
<!-- end of social -->
</div>
<!-- end of header -->
<div id="sidebar">
	<div id="menu">
		<ul>
			<li><a href="#Reflect">Reflect</a></li>
			<li><a href="/Reflect/test">test</a></li>
			<div>
				<br>
				<line space="double">
				<P>
					 A Sentiment Analyzer We Identify, Analyze and Reflect
					(Report) the Positive or Negative Sentiment on any Personal or
					Business Target Entities within any Social media, Webpage and
					Document.<br> What is a Sentiment :<br>It is the attitude, opinion or
					feeling toward something, such as a person, organization, product
					or location Reflect.<br>
			</div>
			<!-- end of menu -->
	</div>
	<!--  end of sidebar -->
</div>
<!-- end of wrapper -->
</body>



<P></P>



<form action="<c:url value="/Reflect/twitter"/>">
	<input type="text" name="user" /> <select name="searchType">
		<option value="#">#-HashTag</option>
		<option value="@">@-Mentions</option>
		<option value="timeLine">timeLine</option>
	</select> <input type="submit" class="buttonSearch" />
</form>

</body>


</html>
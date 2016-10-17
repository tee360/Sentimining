<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sentiment Analyzer</title>
</head>
<body>
	<div class="nav">
		<a href="<c:url value="/"/>">Home</a>
	</div>
	<h1>Sentiment Analyzer</h1>
	<p>
		<c:out value="${ SentimentAnalyzer.type}" />
	</p>
	<p>
		<c:out value="${ SentimentAnalyzer.score}" />
		<p>Running Avg. <c:out value="${ SentimentAnalyzer.runningAvg }" />
	</p>
</body>
</html>
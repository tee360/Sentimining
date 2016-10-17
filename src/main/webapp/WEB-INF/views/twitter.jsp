<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	On this page we show the current tweets.
	
	Model:
	- Twitter twitter
 --%>
<html>
<head>
<%@ include file="parts/head.jsp"%>
</head>
<body>
	<div class="nav">
		<a href="<c:url value="/"/>">Home</a>
	</div>
	<h1>Reflect</h1>
	<p>
		<h1>Sentiment Analyzer</h1>
	<p>
		<c:out value="${ SentimentAnalyzer.type}" />
	</p>
	<p>
		Your score is:
		<c:out value="${ SentimentAnalyzer.score}" />
		<p class="tab">Scale: -100 thru +100		
	</p>
		<p>Ratings: <c:out value="${ SentimentAnalyzer.ratings}" />  out of 5
		<br>
		<p>Overview: <c:out value="${ SentimentAnalyzer.summary}" />
		<br>
		<p>Running Avg. <c:out value="${ SentimentAnalyzer.runningAvg }" />
	</p>
<table class="table table-striped" border="1">
		<thead>
			<tr>
			
				<th>Tweets</th>
			
			</tr>
		</thead>
		<tbody>
	 	<c:forEach var="twitter" items="${twitter}">
				<tr>
					
					<td><c:out value="${ twitter.text}" /></td>
					

				</tr>
				</c:forEach>
		</tbody>
</table>

</body>
</html>
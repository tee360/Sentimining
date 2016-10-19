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
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="nav">
		<a href="<c:url value="/"/>">Home</a>
	</div>
	<h1>Reflect</h1>
	<c:if test="${ empty twitter}">
	
	No tweets available
	</c:if>
	<c:if test="${ not empty twitter}">
		<p>
		<h1>Sentiment Analyzer</h1>
		<p>
			<c:out value="${ SentimentAnalyzer.type}" />
		</p>
		<p>
			<c:out value="${ SentimentAnalyzer.score}" />
		</p>
		<p>
			Ratings:
			<c:out value="${ SentimentAnalyzer.ratings}" />
			out of 5 <br>
		<p>
			Overview:
			<c:out value="${ SentimentAnalyzer.summary}" />
	    <p>
			A Reflection of your score versus the running AvgScore:
			<c:out value="${ averageScore}" />
		<p>
			MaxScore:
			<c:out value="${ maxScore.scoreValue}" />
		<p>
			MaxScore keyword:
			<c:out value="${ maxScore.keyword}" />
		<p>
			MinScore:
			<c:out value="${ minScore.scoreValue}" />
		<p>
			MinScore keyword:
			<c:out value="${ minScore.keyword}" />
		<table class="table table-striped" border="1">
			<thead>
				<tr>

					<th><center><c:out value="${ searchKeyword}" /> Tweets</center></th>

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



	</c:if>
</body>
</html>
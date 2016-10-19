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
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
<br>
<br>
	<ul id="background" class="background">
		<li class="fadein" style="background-image: url("http://static.giantbomb.com/uploads/original/7/79093/1762225-reflection.jpg")
		;"></li>
	</ul>				
				
				
				
				<br>
				<h3 class="text-center">
					<div>
						<span>Reflect</span>
						<c:if test="${ empty twitter}">	
							No tweets available
						</c:if>
					</div>
					<br>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
					<p><b>Top Five</b></p>
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Score</th>
									<th>Rank</th>
									<th>Rating</th>
								</tr>
							</thead>
							<tbody>
								<tr class="active">
									<td></td>
									<td><center><c:out value="${ SentimentAnalyzer.score}"/></td>
									<td><c:out value="${ SentimentAnalyzer.ratings}" /></td>
									<td>Highly Unfavorable</td>
								</tr>
								<tr class="active">
									<td></td>
									<td><center><c:out value="${ SentimentAnalyzer.maxTweetText}"/></td>
									<td>4</td>
									<td>Unfavorable</td>
								</tr>
								<tr class="success">
									<td></td>
									<td>3</td>
									<td>6</td>
									<td>Favorable</td>
								</tr>
								<tr class="warning">
									<td></td>
									<td>4</td>
									<td>8</td>
									<td>Highly Favorable</td>
								</tr>
								<tr class="danger">
									<td></td>
									<td>5</td>
									<td>10</td>
									<td>Excellent</td>
								</tr>
							</tbody>
						</table>
						
						<p><b>Bottom Five</b></p>
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Score</th>
									<th>Rank</th>
									<th>Rating</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="twitter" items="${twitter}">
								<tr>

								<td><c:out value="${ twitter.text}" /></td>


								</tr>
								</c:forEach>
								<tr class="active">
									<td></td>
									<td>2</td>
									<td><c:out value="${ SentimentAnalyzer.maxScore}"/></td>
									<td><c:out value="${ SentimentAnalyzer.maxTweetText}"/></td>
								</tr>
								<tr class="success">
									<td></td>
									<td>3</td>
									<td>6</td>
									<td>Favorable</td>
								</tr>
								<tr class="warning">
									<td></td>
									<td>4</td>
									<td>8</td>
									<td>Highly Favorable</td>
								</tr>
								<tr class="danger">
									<td></td>
									<td>5</td>
									<td>10</td>
									<td>Excellent</td>
								</tr>
							</tbody>
						</table>
						<br>
						<p class="text-left lead">Description</p>
						<p> <c:out value="${ SentimentAnalyzer.summary}" /></p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
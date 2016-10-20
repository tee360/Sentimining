<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<style type="text/css"> 
	body{background-image: "resources/images/BackgroundImage2.jpg"	
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<br> <br>
				<ul id="background" class="background">
					<li class="fadein" style="background-image: url();"></li>
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
		<div class="container">
			<h2>
				<center>Your average tweet score
			</h2>
			<div class="panel panel-default">
				<div class="panel-heading">
					<center>
						<c:out value="${ SentimentAnalyzer.score}" />
						Range: -100 to +100
					</center>
					<div class="panel-body">
						<h3>
							<center>
								<b><c:out value="${ searchKeyword}" /></b>
						</h3>
						<br>
						<div class="panel-body">
							<center>
								Rating:
								<c:out value="${ SentimentAnalyzer.ratings}" />
								out of 5
								<div class="panel-body">
									<center>
										Description:
										<c:out value="${ SentimentAnalyzer.summary}" />
										<div class="panel-body">
											<center>
												Your Best Recent Tweet Score: &nbsp;
												<fmt:formatNumber type="number" maxFractionDigits="2"
													value="${ SentimentAnalyzer.maxScore *100}" />
												<textarea name="tweet" rows="4" cols="50"><c:out
														value="${ SentimentAnalyzer.maxTweetText}" /></textarea>
										</div>
										<div class="panel-body">
											<center>
												Your Worst Recent Tweet Score: &nbsp;
												<fmt:formatNumber type="number" maxFractionDigits="2"
													value="${ SentimentAnalyzer.minScore *100}" />
												<textarea name="tweet" rows="4" cols="50"><c:out
														value="${ SentimentAnalyzer.minTweetText}" /></textarea>
											</center>
										</div>
								</div>
						</div>

						<div class="container">
							<h2>
								<center>Comparisons</center>
							</h2>
							<p>
							<h4>
								<center>For comparison with all other tweets from other
									users
							</h4>
							</p>

							<div class="container-fluid">
								<div class="col-xs-2">
									<label for="ex1">Top overall score </label> <input type="text"
										value="<fmt:formatNumber type="number"
        	maxFractionDigits="2" value="${ maxScore.scoreValue}"/>">
								</div>
								<div class="container-fluid">
									<div class="col-xs-3">
										<label for="ex2">Avg. overall score</label> <input type="text"
											value="${ averageScore}" />
									</div>
									<div class="container-fluid">
										<div class="col-xs-4">
											<label for="ex3">Worst overall score</label> <input
												type="text"
												value="<fmt:formatNumber type="number"
        	maxFractionDigits="2" value="${ minScore.scoreValue}"/>">
										</div>
									</div>

								</div>
								<br>
								<div>
									<br>

								</div>
							</div>
						</div>

						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th><center>Tweet List</center></th>
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

					</div>

					<script src="js/jquery.min.js"></script>
					<script src="js/bootstrap.min.js"></script>
					<script src="js/scripts.js"></script>
</body>
</html>
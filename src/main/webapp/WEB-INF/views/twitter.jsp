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
  			<h2><center>Your average tweet score</h2>
  		<div class="panel panel-default">
    	<div class="panel-heading"><center><c:out value="${ SentimentAnalyzer.score}"/> Range: -100 to +100</div>
    	<div class="panel-body"><center><b><c:out value="${ searchKeyword}" /></b><br>
    		<center>Rating: <c:out value="${ SentimentAnalyzer.ratings}" /> out of 5
    	</div>
  </div>
</div>
								
								<div class="container">
  						<h2><center>Comparisons</center></h2>
  					<p><center>The form below shows your best and worst tweets</p>
  <form>
    <div class="form-group">
      <div class="col-xs-2">
        <label for="ex1">Max Score</label>
        <input class="form-control" id="ex1" type="text"> <c:out value="${ SentimentAnalyzer.maxScore}"/>
        <input class="form-control" id="ex2" type="text"> <c:out value="${ SentimentAnalyzer.maxTweetText}"/>
      </div>
      <div class="col-xs-3">
        <label for="ex2">Running Avg.</label>
        <input class="form-control" id="ex2" type="text"><c:out value="${ averageScore}" />
      </div>
      <div class="col-xs-4">
        <label for="ex3">Min Score</label>
        <input class="form-control" id="ex3" type="text"><c:out value="${ SentimentAnalyzer.minScore}"/>
        <div class="panel-body"><c:out value="${ SentimentAnalyzer.minTweetText}"/>
      </div>
    </div>
  </form>
</div><br>									
									<div>
									<br>
						<p class="text-left lead">Description</p>
						<p> <c:out value="${ SentimentAnalyzer.summary}" /></p>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	On this page we show the current tweets.
	
	Model:
	- Weather weather
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
<table class="table table-striped" border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Text</th>
			
			</tr>
		</thead>
		<tbody>
	 	<c:forEach var="twitter" items="${twitter}">
				<tr>
					<td><c:out value="${ twitter.id}" /></td>
					<td><c:out value="${ twitter.text}" /></td>
					

				</tr>
				</c:forEach>
		</tbody>
</table>

</body>
</html>
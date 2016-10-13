<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%--
	On this page the user can choose to view movies or categories.
	
	Model: none
 --%>
<html>
<head>
<%@ include file="parts/head.jsp"%>
<title>Home</title>
</head>
<body>
	<h1>Reflect</h1>
	<P>The time on the server is ${serverTime}.</P>


	
	<form action="<c:url value="/Reflect/twitter"/>">
		<input type="text" name="user" /> <input type="submit"
			class="buttonSearch" />
	</form>

</body>


</html>

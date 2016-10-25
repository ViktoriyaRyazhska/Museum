<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/images/cover.jpg" var="coverPhoto" />
<spring:url value="/resources/images/avatar.png" var="avatar" />
<spring:url value="/exhibits/all" var="all" />
<spring:url value="/exhibits/byAuthor" var="byAuthor" />
<spring:url value="/exhibits/byMaterial" var="byMaterial" />
<spring:url value="/exhibits/byTechnique" var="byTechnique" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">		
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" >
			<h2 class="w3-wide">Choose exhibits You are interested in:</h2>
			<div class="w3-container w3-content w3-center w3-padding-32" style="max-width: 200px">
				<p><a href="${all}" class="w3-btn-block w3-round w3-teal">List all exhibits</a></p>
				<p><a href="${byAuthor}" class="w3-btn-block w3-round w3-teal">By author</a></p>
				<p><a href="${byMaterial}" class="w3-btn-block w3-round w3-teal">By material</a></p>
				<p><a href="${byTechnique}" class="w3-btn-block w3-round w3-teal">By technique</a></p>
			</div>
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>


<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/exhibits/all" var="all" />
<spring:url value="/exhibits/author" var="byAuthor" />
<spring:url value="/exhibits/material" var="byMaterial" />
<spring:url value="/exhibits/technique" var="byTechnique" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">		
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" >
			<h2 class="w3-wide">Exhibits by author ${author}</h2>			
			
			<c:choose>
				<c:when test="${not empty exhibits}">
				<table class="w3-table w3-striped w3-border w3-bordered w3-hoverable">
					<thead>
					<tr class="w3-light-grey"><th>Name</th><th>Material</th><th>Technique</th><th>Hall</th></tr>
					</thead>
					<c:forEach items="${exhibits}" var="current">
						<tr>
							<td>${current.name}</td>
							<td>${current.material.description}</td>
							<td>${current.technique.description}</td>
							<td>${current.hall}</td>
						</tr>
					</c:forEach>
				</table>
				</c:when>
				<c:otherwise>
					<h2 class="w3-wide">not found!</h2>
					<p>Try another one name:</p>
					
					<form method="post" action="${byAuthor}">
					<p><input type="text" value="" name="authorName" class="w3-input w3-border" /></p>
					<p><input type="submit" class="w3-btn w3-black"/></p>
			</form>	
				</c:otherwise>	
			</c:choose>
			<div class="w3-container w3-content w3-center w3-padding-32" style="max-width: 200px">
				<p><a href="${all}" class="w3-btn-block w3-black">List all exhibits</a></p>
				<p><a href="${byAuthor}" class="w3-btn-block w3-black">By author</a></p>
				<p><a href="${byMaterial}" class="w3-btn-block w3-black">By material</a></p>
				<p><a href="${byTechnique}" class="w3-btn-block w3-black">By technique</a></p>
			</div>		
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>


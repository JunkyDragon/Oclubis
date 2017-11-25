<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${ !empty sessionScope.user }">
	<jsp:forward page="${ contextPath }/main.do"></jsp:forward>
</c:if>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${ contextPath }/jsp/signin.jsp">Sign in</a>
	<a href="${ contextPath }/jsp/signup.jsp">Sign up</a>
	<h1>Oclubis</h1>
	<h2>Oclubis는 디미고인을 위해 개발된 동아리 협업 프로그램입니다.</h2>
</body>
</html>
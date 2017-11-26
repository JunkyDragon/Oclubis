<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<c:if test="${ empty sessionScope.user }">
	<jsp:forward page="${ contextPath }/login.do"></jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ sessionScope.user.club eq club.name and sessionScope.user.permission eq 1}">
		<form action="updateclub.do">
			<button name="club" value="${ club.name }">동아리 소개글 수정</button>
		</form>
	</c:if>
	<c:if test="${ !empty club }">
		동아리명 : ${ club.name } <br>
		동아리장 : ${ club.president } <br>
		동아리 소개 : 
		<c:if test="${ empty club.intro }">동아리 소개가 아직 없습니다</c:if>
		<c:if test="${ !empty club.intro }">${ club.intro }</c:if>
	</c:if>
</body>
</html>

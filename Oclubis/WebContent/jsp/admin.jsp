<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>어드민 페이지</h1><br>
	<form action="${ contextPath }/main.do" method="post">
		<button type="submit">메인으로 이동</button>
	</form>
	<form action="${ contextPath }/user.do" method="post">
		<button type="submit">유저 관리</button>
	</form>
	<form action="${ contextPath }/adminclub.do" method="post">
		<button>동아리 관리</button>
	</form>
	<form action="${ contextPath }/jsp/writeann.jsp" method="post">
		<button>공지 작성</button>
	</form>
</body>
</html>
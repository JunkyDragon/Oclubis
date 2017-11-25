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
	<a href="${ contextPath }/jsp/write.jsp">글쓰기</a>
	<form class="" action="search.do" method="post">
		<select name="condition">
			<option value="theme">제목</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="search" placeholder="검색">
		<button type="submit" name="button">검색</button>
	</form>
	<form action="category.do" method="post">
		<button type="submit" value="1" name="category">1</button>
		<button type="submit" value="2" name="category">2</button>
		<button type="submit" value="3" name="category">3</button>
		<button type="submit" value="4" name="category">4</button>
		<button type="submit" value="5" name="category">5</button>
	</form><br>
	<a href="${ contextPath }/signout.do">로그아웃</a>
	<hr>
	<c:if test="${ empty list }">
		<h1>글이 존재하지 않습니다.</h1>
	</c:if>
	<c:if test="${ !empty list }">
		<c:forEach items="${ list }" var="item">
			글번호 : ${ item.number } <br>
			제목 : ${ item.theme } <br>
			작성자 : ${ item.writer } <br>
			날짜 : ${ item.date } <br>
			카테고리 : ${ item.category } <br>
			내용 : ${ item.content } <br>
			<c:if test="${ sessionScope.user.name eq item.writer }">
				<button></button>
			</c:if>
			<hr>
		</c:forEach>
	</c:if>
</body>
</html>

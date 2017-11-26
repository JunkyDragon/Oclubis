<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>	
</head>
<body>
	<form action="/Oclubis/searchclub.do" method="post">
		<select name="condition">
			<option value="clubname">동아리명</option>
			<option value="president">동아리장</option>
		</select>
		<input type="text" required="required" name="search" placeholder="검색"/>
		<button type="submit">검색</button>
		</form>
		<hr>
		<c:if test="${ empty list }">
			<h1>해당되는 동아리가 없습니다</h1>
		</c:if>
		<c:if test="${ !empty list }">
		<form action="${ contextPath }/club.do" method="post">
			<c:forEach items="${ list }" var="item">
			동아리명 : ${ item.name } <br>
			동아리장 : ${ item.president } <br>
			<button value="${ item.name }" name="club">동아리페이지로</button>
			<hr>
		</c:forEach>
		</form>
		</c:if>
		
	
</body>
</html>
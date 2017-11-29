<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateuser.do" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>동아리</th>
					<th>권한</th>
					<th>선택</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ list }" var="item">
					<tr>
						<td>${ item.id }</td>
						<td>${ item.name }</td>
						<td>${ item.club }</td>
						<td>${ item.permission }</td>
						<c:if test="${ item.permission ne 3}">
							<td><input type="radio" name="check" value="${ item.id }"></td>
						</c:if>
						<c:if test="${ item.permission eq 3}">
							<td></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1>선택한 유저를...</h1>

		<input type="hidden" name="user"> 
		<input type="radio" name="permissionvalue" value="0">동아리원으로 
		<input type="radio" name="permissionvalue" value="1">동아리장으로 
		<input type="radio" name="permissionvalue" value="2">선생님으로 
		<input type="radio" name="permissionvalue" value="3">최고관리자로
		<button type="submit" name="button" value="change">변경</button> <br>
		<button type="submit" name="button" value="delete">제거</button>
	</form>
</body>
</html>
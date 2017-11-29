<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.oclubis.utils.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.oclubis.vo.PostVO"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${ lastnum }"></c:out>
	<c:if test="${ empty sessionScope.user.id }">
		<jsp:forward page="${ contextPath }/login.do"></jsp:forward>
	</c:if>
	<h1>${ sessionScope.user.name }님</h1>
	<h1>${ sessionScope.user.permission }님</h1>
	<a href="${ contextPath }/jsp/write.jsp">글쓰기</a>
	<form action="${ contextPath }/club.do" method="post">
		<button name="club" value="${ sessionScope.user.club }">동방으로</button>
	</form>
	<a href="${ contextPath }/jsp/searchclub.jsp">동아리검색</a>
	<form class="" action="search.do" method="post">
		<select name="condition">
			<option value="theme">제목</option>
			<option value="writer">작성자</option>
		</select> <input type="text" name="search" placeholder="검색">
		<button type="submit" name="button">검색</button>
	</form>
	<form action="category.do" method="post">
		<button type="submit" value="1" name="category">1</button>
		<button type="submit" value="2" name="category">2</button>
		<button type="submit" value="3" name="category">3</button>
		<button type="submit" value="4" name="category">4</button>
		<button type="submit" value="5" name="category">5</button>
	</form>
	<br>
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
			<form action="${ contextPath }/jsp/comment.jsp" method="post">
				<button name="number" value="${ item.number }">댓글 보기</button>
			</form>
			<form action="like.do" method="post">
				좋아요 개수 : 
				<c:forEach items="${like}" var="postlikelist">
					<c:if test="${ postlikelist.key eq item.number }">
						${fn:length(postlikelist.value)}
						<c:set var="boo" value="false" />
						<c:forEach items="${postlikelist.value}" var="postlike">
							<c:if test="${postlike eq sessionScope.user.name}">
								<c:set var="boo" value="true" />
								<button type="submit" name="like" value="dislike">좋아요 해제</button>
							</c:if>
						</c:forEach>
						<c:if test="${ !boo }">
							<button type="submit" name="like" value="like">좋아요</button>
						</c:if>
					</c:if>
				</c:forEach>
			</form>
			<c:if test="${ sessionScope.user.name eq item.writer }">
				<form action="update.do" method="post">
					<button name="number" value="${ item.number }">수정</button>
				</form>
				<form action="delete.do" method="post">
					<button name="number" value="${ item.number }">삭제</button>
				</form>
			</c:if>
			<c:if test="${ sessionScope.user.name ne item.writer }">
				<c:if test="${ sessionScope.user.permission == 3 }">
					<form action="delete.do" method="post">
						<button name="number" value="${ item.number }">삭제</button>
					</form>
				</c:if>
			</c:if>
			<hr>
		</c:forEach>
	</c:if>
</body>
</html>
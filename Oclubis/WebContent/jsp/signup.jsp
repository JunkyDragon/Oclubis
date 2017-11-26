<%@page import="com.oclubis.utils.ClubUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.List" %>
<%@ page import="com.oclubis.utils.*" %>
<%@ page import="com.oclubis.vo.ClubVO" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SignUp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
			<link rel="stylesheet" href="${ contextPath }/css/signin.css">
</head>
<body>
	<div class="container">

		<%
			ClubUtil club = new ClubUtil();
			List<ClubVO> list = club.getClub();
			request.setAttribute("list", list);
		%>
		<form id="signupForm" class="form-signin" action="${contextPath}/signup.do" method="post">
			<h2 class="form-signin-heading">Please sign up</h2>

			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="email" name="id" id="inputEmail" value="${ param.id }" class="form-control" placeholder="Email address" required autofocus />

			<label for="inputPassword" class="sr-only">Password</label>
			<input
				type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required />
				<label for="inputName" class="sr-only">Name</label>
				<input type="text" name="name" id="inputName" value="${ param.name }" class="form-control" placeholder="Name" required />
				<br />
				<div class="form-group">
					<select name="club" required="required" class="form-control" style="height: 47px">
						<option selected="selected" disabled="disabled">Club</option>
						<c:forEach items="${ list }" var="clubs">
							<option value="${ clubs.name }">${ clubs.name }</option>
						</c:forEach>
					</select>
				</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
		</form>
	</div>



	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
	<%@ include file="modal.jsp"%>
	<c:if test="${ error != null }">
		<script>

		<%-- 로그인이 실패한 경우 처리 추가 --%>
			var myModal = $('#myModal');
			myModal.find('.modal-title').text('Login Error');
			myModal.find('.modal-body').text("${ error }");
			myModal.modal();
		</script>
	</c:if>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서 수정</h2>
	<form action="<c:url value='/book/updateBookConfirm'></c:url>" method="post">
		<input type="text" name="b_name" value=${bookDtos.b_name }><br>
		<input type="text" name="b_author" value="${bookDtos.b_author }"><br>
		<input type="text" name="b_publisher" value=${bookDtos.b_publisher }><br>
		<input type="text" value=${bookDtos.b_isbn } readonly disabled><br>
		<input type="hidden" name="b_isbn" value="${bookDtos.b_isbn }">
		<input type="submit" value="수정">
		<input type="reset" value="reset">
	</form>
</body>
</html>
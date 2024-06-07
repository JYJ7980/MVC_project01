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
	<h2>도서 등록</h2>
	<form action="<c:url value='/book/registerBookConfirm'></c:url>" method="post">
		<input type="text" name="b_name" placeholder="도서명"/><br>
		<input type="text" name="b_author" placeholder="저자"/><br>
		<input type="text" name="b_publisher" placeholder="출판사"/><br>
		<input type="text" name="b_isbn" placeholder="isbn"/><br>
		<input type="submit" value="등록"/>
		<input type="reset" value="reset">
	</form>
</body>
</html>
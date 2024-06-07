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
	<jsp:include page="./nav.jsp"></jsp:include>
	<h2>MODIFY ACCOUNT FORM</h2>
	<form action="<c:url value='/admin/modifyAccountConfirm'></c:url>"
		name="modifyAccountConfirm" method="post">
		<input type="text" name="a_id" value="${dto.a_id}" readonly disable /><br>
		<input type="text" name="a_pw" value="******" readonly disable /><br>
		<input type="text" name="a_name" value="${dto.a_name}" } /><br> 
		<input type="text" name="a_phone" value="${dto.a_phone}" /><br> 
		<input type="submit" value="modify account" /> <input type="reset" value="reset">
	</form>
</body>
</html>
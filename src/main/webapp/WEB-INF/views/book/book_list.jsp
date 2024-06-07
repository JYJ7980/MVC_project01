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
	<jsp:include page="../admin/nav.jsp"></jsp:include>
	<h2>book List</h2>
<!-- 	<br> -->
<%-- 		<form action="<c:url value='/admin/searchAdminConfirm'></c:url>"  --%>
<!-- 			name="search_admin_confirm" method="get"> -->
<!-- 			<select name="category"> -->
<!-- 				<option value="None"> == Select Category == </option> -->
<!-- 				<option value="Account"> Account </option> -->
<!-- 				<option value="Name"> Name </option> -->
<!-- 				<option value="Phone"> Phone </option> -->
<!-- 			</select>  -->
<!-- 			<input type="text" name="keyword" placeholder="Enter Keyword"> -->
<!-- 			<input type="submit" value="search"> -->
<!-- 		</form> -->
<!-- 	<br> -->
	<table border="1">
		<tr>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>ISBN</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="dto" items="${bookDtos }">
			<tr>
				<td>
					<c:url value='/book/updateBookForm' var='update_url'>
						<c:param name="isbn" value="${dto.b_isbn }"></c:param>
					</c:url>
					<a href="${update_url}" >${dto.b_name }</a>
				</td>
				<td>${dto.b_author }</td>
				<td>${dto.b_publisher }</td>
				<td>${dto.b_isbn }</td>
				<td>
					<c:url value='/book/deleteBook' var='delete_url'>
						<c:param name="isbn" value="${dto.b_isbn }"></c:param>
					</c:url>
					<a href="${delete_url}" >
						<button>삭제</button>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.co.jyj.jspTest.CarDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		CarDto car1 = new CarDto("가1234", "소나타", 2000);
	request.setAttribute("dto", car1);
	%>

	<h3>EL(Expression Language)</h3>
	<strong>1. CarDto에서 변수 model 출력</strong>
	<br> ${dto.model}
	<br>

	<!--맵으로 변수 출력 -->
	<%
		HashMap<String, CarDto> carMap = new HashMap<String, CarDto>();
		carMap.put("car1", new CarDto("나2222", "모닝", 1000));
		session.setAttribute("carMap", carMap);
	%>
	<strong>2. HashMap에서 변수 model 출력</strong>
	<br> ${sessionScope.carMap.car1.model}
	<br>

	<!--리스트로 변수 출력 -->
	<%
		ArrayList<CarDto> list = new ArrayList<CarDto>();
	list.add(new CarDto("다3333", "태슬라", 3000));
	session.setAttribute("list", list);
	%>
	<strong>3. ArrayList에서 변수 model 출력</strong>
	<br> ${sessionScope.list[0].model}
	<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.House" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿記入画面</title>
</head>
<body>
<%
 request.setCharacterEncoding("UTF-8");
ArrayList<House> resultList = (ArrayList<House>)request.getAttribute("resultList");
%>
	<form action="/Household/Houseservlet" method="get">
		<p><h3>No</h3><label><input type="text" name="keyN"></label></p>
		<p><h3>収入</h3><label><input type="text" name="income"></label></p>
		<p><h3>支出</h3><label><input type="text" name="spending"></label></p>
		<input type="submit" value="記入する">
	</form>

	<form action="/Household/Listservlet" method="get">
		<p><h3>一覧</h3></p>
		<input type="submit" value="一覧">


</body>
</html>
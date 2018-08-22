<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dto.House" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
</head>
<body>
<%
 request.setCharacterEncoding("UTF-8");
ArrayList<House> resultList = (ArrayList<House>)request.getAttribute("resultList");
%>
<table border="1" align="left">
<tr>
<th>No.</th>
<th>収入</th>
<th>支出</th>
</tr>
<%
int i = 0;
while(i < resultList.size()) {
	House result = (House)resultList.get(i);
	out.println("<tr>");
	out.println("<td>" + result.getNumber() + "</td>" + "<td>" + result.getIncome() + "</td>" +
	"<td>" + result.getSpending() + "</td>");
	i = i + 1;
}
%>

</table>

</body>
</html>
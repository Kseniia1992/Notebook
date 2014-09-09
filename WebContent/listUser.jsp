<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ua.cn.notebook.domain.Users"%>
<%@ page import="ua.cn.notebook.service.UserService"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link rel='stylesheet' href='css/list.css' type='text/css'>
	</head>
	<body>
		<header>
  			<h1>Notebook</h1>
		</header>
		<h2>
			<ul><li><a href="DBServlet?action=insert">Добавить контакт</a></li>
				<li><a href="search.jsp">Поиск</a></li></ul>
		</h2>
		<%
			UserService us = new UserService();
			List<Users> userList = us.getAllUsers();
		%>
		<table align=center border="1">
			<tr>
				<th>Номер ID</th>
				<th>Фамилия</th>
				<th>Имя</th>
				<th>Возраст</th>
				<th>Пол</th>
				<th>Номер телефона</th>
				</tr>
			<tr>
		<%
			for (Users user : userList) {
		%>
			<td><%=user.getId()%></td>
			<td><%=user.getSecondName()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getAge()%></td>
			<td><%=user.getGender()%></td>
			<td><%=user.getPhone()%></td>
			<td><a href="DBServlet?action=editform&id=<%=user.getId()%>">Редактировать</a></td>
			<td><a href="DBServlet?action=delete&Id=<%=user.getId()%>">Удалить</a></td>
			</tr>
		<%
			}
		%>
		</table>
	</body>
</html>
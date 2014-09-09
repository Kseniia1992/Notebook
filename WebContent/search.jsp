<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ua.cn.notebook.domain.Users"%>
<%@ page import="ua.cn.notebook.service.UserService"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
		<link rel='stylesheet' href='css/add.css' type='text/css'>
	</head>
	<body>
		<form method="POST" action='DBServlet' name="searchform" ><input
			type="hidden" name="action" value="search" />
		<header>
  			<h1>Notebook</h1>
		</header>
		<h2>
			<ul><li><a href="DBServlet?action=listUser">Контакты</a></li></ul>
		</h2>
		<h3>
			<ul>Поиск:<br />
			<input name="category" type="radio" value="radio1" checked>Номер Id<br />
			<input name="category" type="radio" value="radio2" >Фамилия<br />
			<input name="category" type="radio" value="radio3" >Имя<br />
			<input name="category" type="radio" value="radio4" >Возраст<br />
			<input name="category" type="radio" value="radio5"
			 onchange="document.getElementById('sch').placeholder='Введите f или m'">Пол<br />
			<input name="category" type="radio" value="radio6">Номер телефона<br />
			<input type="text" name="searchInput" id="sch" required placeholder="Введите значение" />
			<input type="submit" id=searchButton value="Поиск" /></ul>
		</h3>
		<%
			String search_input = request.getParameter("searchInput");
			UserService us = new UserService();
			List<Users> userList = new ArrayList<Users>();
		%>
		<%
			if(request.getParameter("category") != null){
				if(request.getParameter("category").equals("radio1")) {
					int search_id = Integer.parseInt(search_input);
					userList = us.getUsersById(search_id);
				} else if(request.getParameter("category").equals("radio2")){
					userList = us.getUsersBySecondName(search_input);
				} else if(request.getParameter("category").equals("radio3")) {
					userList = us.getUsersByFirstName(search_input);
				} else if(request.getParameter("category").equals("radio4")) {
					int search_age = Integer.parseInt(search_input);
					userList = us.getUsersByAge(search_age);
				} else if(request.getParameter("category").equals("radio5")){
					userList = us.getUsersByGender(search_input);
				} else if(request.getParameter("category").equals("radio6")){
					userList = us.getUsersByPhone(search_input);	
				}
			}
		%>
		<div id="tablediv">
			<table id="searchTable" align=center border="1">
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
				</tr>
					<%
						}
					%>
			</table>
		</div>
		</form>
	</body>
</html>
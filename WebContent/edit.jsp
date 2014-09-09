<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ua.cn.notebook.domain.Users"%>
<%@ page import="ua.cn.notebook.service.UserService"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link rel='stylesheet' href='css/add.css' type='text/css'>
	</head>
	<body>
		<header>
  			<h1>Notebook</h1>
		</header>
		<h2>
			<ul><li><a href="DBServlet?action=listUser">Контакты</a></li>
				<li><a href="">Поиск</a></li>
			</ul>
		</h2>
		<%
			Users user = new Users();
		%>
		<%
			UserService us = new UserService();
		%>
		<form method="POST" action='DBServlet' name="frmEditUser"><input
			type="hidden" name="action" value="edit" />
		<script src='js/addUser.js' type="text/javascript" charset="UTF-8"></script>
		<%
			String uId = request.getParameter("id");
			String age = request.getParameter("age");
			if (!((uId) == null)) {
				int id = Integer.parseInt(uId);
				user = us.getObjectById(id);
		%>
		<table border="1">
			<tr>
				<th>Номер ID</th>
				<td><input type="text" name="id" readonly="readonly" value="<%=user.getId()%>"></td>
			</tr>
			<tr>
				<th>Фамилия</th>
				<td><input type="text" name="secondName" onchange="addUserSecondName(this.value)" required/></td>
			</tr>
			<tr>
				<th>Имя</th>
				<td><input type="text" name="firstName" required/></td>
				</tr>
			<tr>
				<th>Возраст</th>
				<td><input type="text" name="age"  onchange="addUserAge(this.value)" required/></td>
			</tr>
			<tr>
				<th>Пол</th>
				<td><input type="text" name="gender" onchange="addUserGender(this.value)" list="gender" required/>
					<datalist id="gender">
    					<option>f</option>
    					<option>m</option>
    				</datalist> </td></td>
			</tr>
			<tr>
				<th>Номер телефона</th>
				<td><input type="text" name="phone"  onchange="addUserPhone(this.value)" 
				           placeholder="+(xxx)xxx-xx-xx" required/></td>
			</tr>
		</table>
		<%
			} else
			out.println("ID Not Found");
		%>
		<p><input type="submit" id=submitButton value="Обновить" disabled="disabled" required/></p>
		</form>
	</body>
</html>
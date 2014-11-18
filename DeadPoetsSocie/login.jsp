<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  <title>Sign</title>
	</head>
	  <body>
		<h1>Please sign up</h1>
		<div class = "form">
			<c:url value = "/j_spring_security_check" var = "loginURL"/>
			<form method = "POST" action = "${loginURL}" >
				<table>
					<tr>
						<td>Login</td>
						<td><input type = "text" name ="j_username"/></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type = "text" name ="j_password"/></td>
					</tr>
					<tr>
						<td>Remember me</td>
						<td><input type = "checkbox" name ="j_spring_security_remember_me"/></td>
					</tr>
					<tr>
						<td><input type = "submit" value = "Sign"></td>
						<td><input type = "reset" value = "Reset"></td>
					</tr>
				</table>
			</form>
		</div>
	  </body>
</html>


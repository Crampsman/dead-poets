<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<title>Registration form</title>
  		<link href="resources/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
  <body>
  <div class = "form">
 	<sf:form method = "POST" modelAttribute = "writer" action = "addWriter" enctype = "multipart/form-data">
  		<table>
  			<caption>Registration form</caption>
  			<tr>
  				<th><label for = "username">Login</label></th>
  				<td><sf:input path = "username" size = "30"/>
  				<small>No spaces, please</small><br/>
  				<sf:errors path = "username" cssClass = "error"/>
  				</td>
  			</tr>
  			<tr>
  				<th><label for = "firstname">Firstname</label></th>
  				<td><sf:input path = "firstname" size = "30"/><br/>
  				<sf:errors path = "firstname" cssClass = "error"/>
  				</td>
  			</tr>
  			<tr>
  				<th><label for = "lastname">Lastname</label></th>
  				<td><sf:input path = "lastname" size = "30"/><br/>
  				<sf:errors path = "lastname" cssClass = "error"/>
  				</td>
  			</tr>
  			<tr>
  				<th><label for = "email">E-mail</label></th>
  				<td><sf:input path = "email" size = "30"/>
  				<small>Don't forget something in your case</small><br/>
  				<sf:errors path = "email" cssClass = "error"/>
  				</td>
  			</tr>
  			<tr>
  				<th><label for = "password">Password</label></th>
  				<td><sf:input path = "password" size = "30" showPassword = "true"/>
  				<small>6 characters or more </small><br/>
  				<sf:errors path = "password" cssClass = "error" />
  				</td>
  			</tr>
  			<tr>
  				<th><label for = "image">Avatar</label></th>
  				<td><input type = "file" name = "image" /></td>
  			<tr>
  				<th></th>
  				<td><input type = "submit" name = "Send"></td>
  			</tr>
  		</table>
  	</sf:form>
  </div>
  </body>
 </html>
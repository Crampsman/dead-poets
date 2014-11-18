<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<title>Create a new post</title>
 	</head>
 <body>
 

		<h2>Add new post</h2>
	<sf:form method = "POST" modelAttribute = "post" action = "addPost">
  		<table>
  			<tr>
  				<td>Write your title</td>
  			</tr>
  			<tr>
  				<td><sf:textarea path = "title" rows = "2" cols = "50"/></td>
  			</tr>
  			<tr>
  				<td>Write your text</td>
  			</tr>
  			<tr>
  				<td><sf:textarea path = "text" rows = "15" cols = "50"/></td>
  			
  			</tr>
  			<tr>
  				<td><input type = "submit" name = "Send"></td>
  			</tr>
  		</table>
  	</sf:form>
  	 <div>
	<h1>All my publications</h1>
	<table>
		<c:forEach items = "${writer.posts}" var = "post">
			<tr>
				<td><h2>${post.title}</h2></td>
			</tr>
			<tr>
				<td>${post.text}</td>
			</tr>
			<tr>
				<td>${post.current_date}</td>
			</tr>
			<tr>
				<td><a href = "delete/${post.post_id}">Delete</a></td>
			</tr>
			
			
			
		</c:forEach>
	</table>
</div>
	

	
 </body>
</html>


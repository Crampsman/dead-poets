<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="resources/css/home.css" rel="stylesheet" type="text/css"/>
		<link href="resources/css/form.css" rel="stylesheet" type="text/css"/>
  		<title>Create a new post</title>
 	</head>
 <body>
 	<div class = "wrapper">
	 <h2>Add new post</h2>
		<div class = "form">
			<sf:form method = "POST" modelAttribute = "post"  action = "addPost">
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
	  	</div>
	  	
	  	
		<h1>All my publications</h1>
		<div>
			<table>
				<tr>
					<td>
		 				<form action = "edit" method = "GET">
		 					<p><button type="submit" name = "show" value = "all">Show all post</button>
		 					<button type="submit" name = "show" value = "app">Show approved post</button>
		 					<button type="submit" name = "show" value = "ban">Show ban post</button></p>
		 				</form>
		 			</td>
				</tr>
			</table>
		</div>
	
		<c:forEach items = "${posts}" var = "post">
			<table>
				<tr>
					<td><h2><c:out value = "${post.title}"/></h2></td>
				</tr>
				<tr>
				    <td><c:out value = "${post.text}"/></td>
				</tr>
				<tr>
					<td></td>
				    <td><i><c:out value = "${post.current_date}"/></i></td>
				</tr>
				<tr>
				    <td>Display status <b><c:out value = "${post.showPost}"/></b></td>
				</tr>
			</table>
			<br/>
		</c:forEach>
	</div>
	<h3 align = "center"><a href = "/DeadPoetsSocie/home">Return home</a></h3>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<title>Admin account</title>
  		<link href="resources/css/home.css" rel="stylesheet" type="text/css"/>
  		<link href="resources/css/form.css" rel="stylesheet" type="text/css"/>
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
 
  <div>
  <h1>list of all publications unconfirmed</h1>
  	
 		<c:forEach items = "${allPosts}" var = "post">
			<table>
				<tr>
					<td><h3><c:out value = "${post.writer.username}"/></h3></td>
				</tr>
				<tr>
					<td><h3><c:out value = "${post.title}"/></h3></td>
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
 			<tr>
 				<td>
 					<form action = "approved/${post.post_id}" method = "GET">
 						<button type="submit" name = "check" value = "true">Approved post</button>
 					</form>
 				</td>
 				<td>
 					<form action = "deletePost/${post.post_id}" method = "GET">
 						<button type="submit">Delete</button>
 					</form>
 				</td>
 			</tr>
 		</table>
 		<br/>
 	  </c:forEach>
 	</div>
 
 <div>
  <h1>List of all writers</h1>
 	<table border = "1px">
 		<c:forEach items = "${writers}" var = "writer">
 			<tr>
 				<td><c:out value="${writer.username}"/></td>
 			    <td><c:out value="${writer.enable}"/></td>
 				<td>
 					<form action = "deleteWriter/${writer.writer_id}" method = "GET">
 						<button type = "submit">Delete</button>
 					</form>
 				</td>
 				<td>
 					<form action = "disable/${writer.writer_id}" method = "GET">
 						<button type = "submit" name = "check" value = "false">Disable</button>
 				        <button type = "submit" name = "check" value = "true">Enable</button>
 					</form>
 				</td>
 			</tr>
 		</c:forEach>
 	</table>
 </div>
<h3 align = "center"><a href = "/DeadPoetsSocie/home">Return home</a></h3>
 </div>
 </body>
</html>


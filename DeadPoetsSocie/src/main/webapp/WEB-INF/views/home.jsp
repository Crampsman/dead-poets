<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<title>Dead Poets Society - share your ideas</title>
  		<link href="resources/css/home.css" rel="stylesheet" type="text/css"/>
    </head>
  <body>
 
  <div class = "wrapper">
	<h1 align = "center">Dead Poets Society - share your ideas. Here you can read, think and create.</h1><br/>
	<div class = "coll_1">
		<sec:authorize access = "isAuthenticated()">
			<sec:authentication property = "principal.username" var = "nameId" scope = "request"/>
			<ul>
				<li><h2><a href  = "<c:url value = "/account/${nameId}/edit"/>">Personal account</a></h2></li>
				<li><h2><a href = "<c:url value = "/logout"/>">Exit</a></h2></li>
			</ul>
		</sec:authorize>
		
		<sec:authorize access = "!isAuthenticated()">
			<h2 align = "center">Do you want add your post? Just sign!</h2>
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
			<h2 align = "center">Are you still not join us?<br/>
		    <a href = "<c:url value = "/add-to-society"/>">So come on - it's easy!</a></h2>
		</sec:authorize>
	</div>
	
	 <div 	class = "coll_3">
		<ul>
			<li><h2><a href = "<c:url value = "writers/all-posts"/>">Show all post</a></h2></li>
			<li><h2><a href = "<c:url value = "/writers"/>">Show table of writer</a></h2></li>
		</ul>
	</div>
		
	
	<div class = "coll_2">
		<div id = "cross"><h1>From the last ...</h1></div>
			<c:forEach items = "${postList}" var = "post">
				<s:url value ="/writers/{writerId}" var = "writer_url">
					<s:param name ="writerId"  value = "${post.writer.writer_id}"/>
				</s:url>
				<table>	
					<tr>
						<td><img src = "${post.writer.avatar}"><br/>
						<a href = "${writer_url}"><c:out value = "${post.writer.firstname}"/> <c:out value = "${post.writer.lastname}"/></a></td>
					</tr>
					<tr>
						<td class = "post_border"><h3><c:out value = "${post.title}"/></h3>
						<c:out value = "${post.text}"/></td>
					</tr>
					<tr>
						<td></td>
						<td><c:out value = "${post.current_date}"/></td>
					</tr>
				</table>
			<br/>
		</c:forEach>
	</div>
  </div>
 </body>
</html>


<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<title>Writer publications</title>
    </head>
  <body>
 <div>
	<h1>On this page you can see all publications <c:out value = "${writer.firstname}"></c:out></h1>
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
		</c:forEach>
	</table>
</div>
 </body>
</html>

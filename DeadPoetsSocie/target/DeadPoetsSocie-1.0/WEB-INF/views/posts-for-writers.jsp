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
  		<link href="resources/css/home.css" rel="stylesheet" type="text/css"/>
    </head>
  <body>
 <div class = "coll_2">
		<div id = "cross"><h1>All publications</h1></div>
			<c:forEach items = "${allPosts}" var = "post">
				<table>	
					<tr>
						<td><c:out value = "${post.writer.firstname}"/> <c:out value = "${post.writer.lastname}"/></td>
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
	<h3 align = "center"><a href = "/DeadPoetsSocie/home">Return home</a></h3>
 </body>
</html>

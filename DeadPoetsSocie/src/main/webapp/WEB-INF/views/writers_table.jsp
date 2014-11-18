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
  		<title>All the writers of "Dead Poets Society"</title>
 	</head>
 <body>
  <h1>Choice the writer</h1>
 <table>
     <c:forEach items = "${writerList}" var = "writer">
     	<s:url value ="/writers/{writerId}" var = "posts_url">
			<s:param name ="writerId"  value = "${writer.writer_id}"/>
		</s:url>
			<tr>
				<td><a href ="${posts_url}"><c:out value = "${writer.username}"></c:out></a><td>
				<td><img src = "${writer.avatar}"></td>
			</tr>
		</c:forEach>
	</table>
 </body>
</html>


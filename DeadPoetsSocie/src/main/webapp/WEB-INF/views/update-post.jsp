<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<title>Update post</title>
 	</head>
 <body>
 
	<div>
	<h2>Update your post</h2>
	<sf:form method = "POST" modelAttribute = "updatePost"  action = "updatePost">
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
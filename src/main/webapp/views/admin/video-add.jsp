<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/admin/video/insert'></c:url>"
		method="post" enctype="multipart/form-data">
		<label for="fname">Link:</label>
		<br> 
		<input type="text"id="videoid" name="videoid">
		<br>
		<label for="fname">Title:</label>
		<br> 
		<input type="text"id="title" name="title">
		<br>
		<label for="fname">description:</label>
		<br> 
		<input type="text"id="description" name="description">
		<br> 
		<label for="fname">View:</label>
		<br> 
		<input type="text"id="views" name="views">
		<br>
		<label 
			for="lname">Poster:</label>
		<br> 
		<img height="150" width="200"
			src="" id="posters" /> 
		<input type="file" onchange="chooseFile(this)" id="poster" name="poster">
		<p>Active:</p>
		<input type="radio" id="ston" name="actives" value="10" checked>
		<label for="html">Đang hoạt động</label>
		<br>
		<input type="radio" id="stoff" name="actives" value="0"> <label for="css">Khóa</label><br>
		<label for="fname">CategoryID:</label>
		<br> 
		<input type="text" id="categoryid" name="categoryid">
		<input type="submit" value="insert">
	</form>
</body>
</html>
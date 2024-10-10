<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='/admin/video/update'></c:url>"
		method="post" enctype="multipart/form-data">
		<label for="fname">Link:</label>
		<br> 
		<input type="text"id="videoid" name="videoid" value = "${video.videoId }">
		<br>
		<label class="form-label" for="lname">Upload Video:</label><br>
		<input class="form-input" type="file" id="lname1" name="videoid1" >
		<br>
		<label for="fname">Title:</label>
		<br> 
		<input type="text"id="title" name="title" value = "${video.title }">
		<br>
		<label for="fname">description:</label>
		<br> 
		<input type="text"id="description" name="description" value = "${video.description }">
		<br> 
		<label for="fname">View:</label>
		<br> 
		<input type="text"id="views" name="views" value = "${video.views }">
		<br>
		<label 
			for="lname">Poster:</label>
		<br> 
		<c:if test="${video.poster.substring(0 , 5)=='https'}">
			<c:url value="${video.poster}" var="imgUrl"></c:url>
		</c:if>
		<c:if test="${video.poster.substring(0 , 5)!='https'}">
			<c:url value="/image?fname=${video.poster }" var="imgUrl"></c:url>
		</c:if>
		<img height="150" width="200"
			src="${imgUrl}" id="posters" /> 
		<input type="file" onchange="chooseFile(this)" id="poster" name="poster">
		<p>Active:</p>
		<input type="radio" id="ston" name="actives" value="1" ${video.active==1?'checked':'' }>
		<label for="html">Đang hoạt động</label>
		<br>
		<input type="radio" id="stoff" name="actives" value="0" ${video.active!=1?'checked':'' }> <label for="css">Khóa</label><br>
		<label for="fname">CategoryID:</label>
		<br> 
		<input type="text" id="categoryid" name="categoryid" value = "${video.category.categoryid }">
		<input type="submit" value="insert">
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Responsive Layout Example</title>
<link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
	<a href="<c:url value='/admin/video/add'></c:url>">Add video</a>

	<table border="1">
		<tr>
			<th>STT</th>
			<th>VideoID</th>
			<th>Poster</th>
			<th>Title</th>
			<th>Description</th>
			<th>Active</th>
			<th>Views</th>
			<th>Categoryid</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${listvideo}" var="video" varStatus="VideoID">
			<tr>
				<td>${STT.index+1 }</td>
				<c:if test="${video.videoId.substring(0,5)=='https'}">
					<c:url value="${video.videoId}" var="vidUrl"></c:url>
				</c:if>
				<c:if test="${video.videoId.substring(0,5)!='https'}">
					<c:url value="/video?fname=${video.videoId}" var="vidUrl"></c:url>
				</c:if>
				<td><video width="120" height="160" controls>
						<source src="${vidUrl }" type="video/mp4">
					</video></td>
				<c:if test="${video.poster.substring(0 , 5)=='https'}">
					<c:url value="${video.poster}" var="posterUrl"></c:url>
				</c:if>

				<c:if test="${video.poster.substring(0 , 5)!='https'}">
					<c:url value="/image?fname=${video.poster }" var="imgUrl"></c:url>
				</c:if>

				<td><img height="150" width="200" src="${imgUrl}" /></td>

				<td>${video.title }</td>

				<td>${video.description }</td>

				<td>${video.views }</td>

				<td>${video.active}</td>

				<td>${video.category.categoryid }</td>

				<td><a
					href="<c:url value='/admin/video/edit?videoid=${video.videoId }'/>">Sửa</a>

					| <a
					href="<c:url value='/admin/video/delete?videoid=${video.videoId }'/>">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><img src="../resources/upload/${filename }"></p>
	<p>${oname }</p> <a href="fileDelete?fileName=${filename}">삭제</a>
	<a href="fileDown?fileName=${filename }&oname=${oname}">다운로드</a> 
	<!-- 사진을 보는것만이 아닌, 다운로드를 위한 경로를 따로 생성함 (click to Download) -->
</body>

</html>
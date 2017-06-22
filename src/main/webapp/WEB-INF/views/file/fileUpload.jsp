<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type=text name=name>
		<input type=file name=f1>
		<button>Upload!</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>글쓰기임</h1>
<form action="${path }Write" method=post>
	<input type=text name=writer value=${dto.writer }>
	<input type=text name=title value=${dto.title }>
	<textarea name=content>${dto.content }</textarea>
	<input type=submit value=WRITE>
</form>
</body>
</html>
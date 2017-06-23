<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>수정폼임</h1>
<form action="${path}Update" method=post>
	<c:catch>
	<input type=hidden name=num value=${dto.num }>
	</c:catch>
	<input type=text name=title value=${dto.title }>
	<textarea name=content>${dto.content }</textarea>
	<input type=submit>
</form>
</body>
</html>
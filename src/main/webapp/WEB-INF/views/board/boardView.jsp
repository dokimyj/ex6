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

<h1>게시글임</h1>
${dto.num }<br>
${dto.writer }<br>
${dto.title }<br>
${dto.content }<br>
${dto.hit }<br>
<a href="${board }List?curPage=1">리스트</a>
<a href="${board }Update?num=${dto.num }">수정</a>
<a href="${board }Delete?num=${dto.num }">삭제</a>
</body>
</html>
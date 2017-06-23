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

<h1>${board }</h1>
<div>
	<form action="${board }List" id=f>
		<select name=search >
			<option value=title>Title</option>
			<option value=writer>Writer</option>
			<option value=content>Content</option>
		</select>
		<input type=text name=find>
		<input type=submit value=SEARCH>
		<input type=hidden name=curPage id=curPage value=${listInfo.curPage }>
	</form>
</div>
<c:forEach items="${list }" var="dto">
	${dto.num } &nbsp; <c:catch><c:forEach begin="1" end="${dto.depth }">>></c:forEach></c:catch><a href="${board }View?num=${dto.num }">${dto.title }</a> &nbsp; ${dto.writer } &nbsp; ${dto.regdate } &nbsp; ${dto.hit }
	<br>
</c:forEach>
<br>
<a href="${board }List">리스트</a>
<a href="${board }Write">글쓰기</a>

<c:if test="${listInfo.curBlock >1 }">
	<span id='backwards'>&lt;</span>
</c:if>
<c:forEach begin="${listInfo.firstNum }" end="${listInfo.lastNum }" step="1" var="i">
	<span class='curPage'>${i }</span>
</c:forEach>
<c:if test="${listInfo.curBlock ne listInfo.totalBlock }">
	<span id='forwards'>&gt;</span>
</c:if>

</body>
<script>
	$('#backwards').click(function(){
		$('#curPage').val(${listInfo.firstNum-1});
		$('#f').submit();
	});

	$('#forwards').click(function(){
		$('#curPage').val(${listInfo.lastNum+1});
		$('#f').submit();
	});
	
	var parameter = "&search=${listInfo.search}&find=${listInfo.find}";	
	$(".go").click(function() {
			
		document.frm.curPage.value = $(this).attr("id");
		document.frm.search.value = '${listInfo.search}';
		document.frm.find.value = '${listInfo.find}';
		document.frm.submit();
			/* location.href= "${board}List?curPage="+cur+parameter; */
	});
		
	var m='${message}';
	if(m!=''){ //글쓰기하고 message가 flashAttribute로 전송된 경우에만 alert창을 띄움
		alert(m); 
	}
</script>
</html>
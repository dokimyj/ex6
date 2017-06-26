<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../resources/js/memo.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div>
		<form action="">
			<input type=text id=writer>
			<input type=text id=content>
			<input type=button id=btn value=쓰기>
		</form>
	</div>
	<div id=result> <!-- spring에서 controller없이 AJAX로 내용넣기 -->
	
	</div>
	<div id=result2>
	
	</div>
	<input type=button id=viewbtn value=보기>
</body>
<script>
	$(function(){
		getList();
		$("#btn").click(function(){
			var writer=$('#writer').val();
			var content=$('#content').val();
			memoWrite(content, writer);
		}); 
		$("#viewbtn").click(function(){
			memoView(1);
		});
	});
</script>
</html>
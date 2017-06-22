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
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type=text name=name>
		<input type=file name=f1>
		<button>Upload!</button>
	</form>
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<input type=text name=name>
		<input type=file name=f1>
		<input type=file name=f2>
		<button>Upload!</button>
	</form>
	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<input type=text name=name>
		<input type=file name=f1>
		<input type=file name=f1>
		<button>Upload!</button>
	</form>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type=text name=name>
		<div id=file>
			
		</div>
		<input type=button id=add value=파일추가>
		<button>Upload!</button>
	</form>
</body>
<script>
	var i=0;
	$('#add').click(function(){
		$('#file').append("<p title=k"+i+"><input type=file name=f"+i+"><span name=k"+i+">x</span></p>");
		i++;
	});
	$('#file>p>span').click(function(){
		if($('#file').prop('title')==$('#file').prop('name:last-child')){
			$('#file').prop('title').remove();
		}
	});
</script>
</html>
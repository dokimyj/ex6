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
	<form action="newUpload" method="post" enctype="multipart/form-data">
		<input type=text name=name>
		<div id=files>
			
		</div>
		<input type=button id=add1 value=파일추가>
		<button>Upload!</button>
	</form>
</body>
<script>
	var i=0;
	$('#add').click(function(){
		if(i<5){
			$('#file').append("<p><input type=file name=f1><span class=del>x</span></p>");
			i++;
		}else{
			alert('5개까지만 첨부 가능합니다.');
		}
	});
	$('#file').on("click",".del", function(){
		$(this).parent().remove();
		i--;
	});
	
	var j=0;
	$('#add1').click(function(){
		if(j<5){
			$('#files').append("<p><input type=file name=x"+j+"><span class=del1>x</span></p>");
			j++;
		}else{
			alert('5개까지만 첨부 가능합니다.');
		}
	});
	$('#files').on("click",".del1", function(){
		$(this).parent().remove();
		j--;
	});
</script>
</html>
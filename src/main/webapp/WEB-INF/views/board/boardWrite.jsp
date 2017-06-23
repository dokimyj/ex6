<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
$(function(){
var editor_object = [];

nhn.husky.EZCreator.createInIFrame({
    oAppRef: editor_object,
    elPlaceHolder: "smarteditor",
    sSkinURI: "../resources/SE2/SmartEditor2Skin.html", 
    htParams : {
        // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
        bUseToolbar : true,             
        // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
        bUseVerticalResizer : true,     
        // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
        bUseModeChanger : true, 
    }
});
 
//전송버튼 클릭이벤트
$("#savebutton").click(function(){
    //id가 smarteditor인 textarea에 에디터에서 대입
    editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
     
    // 이부분에 에디터 validation 검증
     
    //폼 submit
    $("#frm").submit();
});

});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>글쓰기임</h1>
<form action="${path }Write" method=post id=frm>
	<input type=text name=writer value=${dto.writer }>
	<input type=text name=title value=${dto.title }>
	<textarea name=content id=smarteditor>${dto.content }</textarea>
	<input type=button value=WRITE id=savebutton>
</form>
</body>

</html>
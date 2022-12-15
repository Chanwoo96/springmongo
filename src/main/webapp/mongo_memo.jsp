<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
h3{
width: 800px;
height: 100px;
background: yellow;
}
</style>
<script type="text/javascript" src="resources/js/jquery-3.6.1.js"></script>
<script type="text/javascript">
$(function() {
		$.ajax({
			url:"list.memo",
			success: function(x) {
				$('#result').html(x)
			}
		})
})
</script>
</head>
<body>
<h3>멀티 메모장</h3>
<hr color="blue">
<form action="insert.memo">
작성자:<input name="name" value="win"> 
내용:<input name="content" value="funfun"> 
날씨:<input name="weather" value="good"> <br>
<button id="b1">서버로 전송</button>
</form>
<hr color="blue">
<div id="result" ></div>
</body>
</html>
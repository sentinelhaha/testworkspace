<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>实现文件长传</h1>
	<form action="http://localhost:8080/CROWN-BS-SYS-V1/file.do" method="post" 
	enctype="multipart/form-data">
		<input name="fileImage" type="file" />
		<input type="submit" value="提交"/>
	</form>
	<img alt="picture" src="http://192.168.2.81:8002/static/lunbo/15470219803931913.jpg">
</body>
</html>
<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table</title>
<script type="text/javascript">
	window.fetch("http://localhost:8080/student-app/students").then(function(response){
		return response.json();
	}).then(funstion(data){
		console.log(data);
	});
</script>
</head>
<body>
	<table id="students">
	
	</table>
</body>
</html>
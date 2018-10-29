<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<html>
<body>
	<form action="/student-app/teachers" method="POST">
		<input type="hidden" name ="formName" value="add">
		<div class="form-group">
		<label for="fname">First Name</label>
		<input type="text" name="firstName" placeholder="first name" id="fname" class="form-control">
		</div>
		<div class="form-group">
		<label for="sname">Second Name</label>
		<input type="text" name="secondName" placeholder="second name" id="sname" class="form-control">
		</div>
		<div class="form-group">
		<label for="group">Group</label>
		<input type="text" name="groupNumber" placeholder="group" id="group" class="form-control">
		</div>
		<button type="submit" class="btn btn-primary">Send</button>
	</form>

	<table class="table table-bordered" >
		<thead>
			<tr>
				<th>First Name  </th>
				<th> Second Name </th>
				<th> Group Number </th>
				<th> Average Mark </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
			
			<tr>
				<td>${student.firstName}</td>
				<td>${student.secondName}</td>
				<td align=center>${student.groupNumber}</td>
				<td align=center>${student.avgMark}</td>
				<td>
				<form action="/student-app/teachers" method="POST">
					<input type="hidden" name="id" value="${student.id}"/>
					<input type="submit" name="deleteButton" value="Delete"/>
					<input type="hidden" name ="formName" value="delete"/>
					
				</form>
				</td>
			</tr>		
			</c:forEach>
			
		</tbody>

	</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<form action="saveDetails.do" method="post">

		<div>
			<p>
				Enter Your Name: <input type="text" name="changeNoteName"/><br>
				Enter Your Email: <input type="text" name="email"/><br>
				Enter your Contact Number: <input type="text" name="contactNumber"/><br>
				<input type="submit" value="Submit">

			</p>
		</div>
		<div>
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Contact Number</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="changeNote" items="${changeNotes}">
					<tr>
						<td><c:out value="${changeNote.changeNoteId}" /></td>
						<td><c:out value="${changeNote.changeNoteName}" /></td>
						<td><c:out value="${changeNote.email}" /></td>
						<td><c:out value="${changeNote.contactNumber}" /></td>
						<td><input type="button" value="Edit" onclick="updateDetails()"></td>
						<td><input type="submit" value="Delete"	onclick="form.action='deleteDetails.do?empId=${changeNote.changeNoteId}';"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>
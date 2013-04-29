<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> --%>
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SpringMVC Hibernate</title>
</head>
<body>

	<h2>Add New Contact</h2>

	<form method="post" action="addContact">

		<table>
			<tr>
				<td>FirstName :</td>
				<td><input type="text" id=firstname name="firstname"><br /></td>
			</tr>
			<tr>
				<td>LastName :</td>
				<td><input type="text" id=lastname name="lastname"><br /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" id=email name="email"><br /></td>
			</tr>
			<tr>
			<td>phone.:</td>
				<td><input type="text" id=telephone name="telephone"><br /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
		</form>


		 
<c:if  test="${!empty allContacts}">
<h3>Contacts</h3>
<table>
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Actions</th>
</tr>
<c:forEach items="${allContacts}" var="contact">
    <tr>
        <td>${contact.firstname} ${contact.lastname} </td>
        <td>${contact.email}</td>
        <td>${contact.telephone}</td>
        <td><a href="contacts/delete/${contact.id}">delete</a></td>
        <td><a href="contacts/edit/${contact.id}">edit</a></td>
    </tr>
</c:forEach>
</table>
</c:if> 
</body>
</html>
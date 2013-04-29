
<html>
<head>
<title>SpringMVC Hibernate</title>
</head>
<body>

	<h2>Edit Contact</h2>

	<form method="POST" action="/SpringMVCHib/updateContact">

		<table>
			<tr>
				<td>FirstName :</td>
				<td><input type="text" id=firstname name="firstname" value = "${contact.firstname}"><br /></td>
			</tr>
			<tr>
				<td>LastName :</td>
				<td><input type="text" id=lastname name="lastname" value = "${contact.lastname}"><br /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" id=email name="email" value = "${contact.email}"><br /></td>
			</tr>
			<tr>
			<td>phone.:</td>
				<td><input type="text" id=telephone name="telephone" value = "${contact.telephone}"><br /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
			<td><input type="hidden" name="contact_id" value ="${contact.id}"><br /></td>
		</table>
		</form>


		 <h3>Contacts</h3>
</body>
</html>
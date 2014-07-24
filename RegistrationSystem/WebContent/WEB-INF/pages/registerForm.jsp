<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
<h1> Registration Form</h1>
<form:form method="POST" commandName="customerForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Full Name :</td>
				<td><form:input path="name" />
				</td>
				<td><form:errors path="name" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:radiobutton path="gender" value="M" />Male 
                                       <form:radiobutton path="gender" value="F" />Female</td>
				<td><form:errors path="gender" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>State :</td>
				<td><form:input path="state" />
				</td>
				<td><form:errors path="state" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Occupation :</td>
				<td><form:input path="occupation" />
				</td>
				<td><form:errors path="occupation" cssClass="error" />
				</td>
			</tr>
	<%-- 		<tr>
				<td>Confirm Password :</td>
				<td><form:password path="confirmPassword" />
				</td>
				<td><form:errors path="confirmPassword" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Subscribe to newsletter? :</td>
				<td><form:checkbox path="receiveNewsletter" />
				</td>
				<td><form:errors path="receiveNewsletter" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Favourite Web Frameworks :</td>
				<td><form:checkboxes items="${webFrameworkList}"
					path="favFramework" /></td>
				<td><form:errors path="favFramework" cssClass="error" />
				</td>
			</tr>
			
			<tr>
				<td>Choose a number :</td>
				<td><form:radiobuttons path="favNumber" items="${numberList}" />
				</td>
				<td><form:errors path="favNumber" cssClass="error" />
				</td>
			</tr> --%>
			<tr>
				<td>Country :</td>
				<td><form:input path="country" /></td>
				<td><form:errors path="country" cssClass="error" />
				</td>
			</tr>
			<%-- <tr>
				<td>Java Skills :</td>
				<td><form:select path="javaSkills" items="${javaSkillsList}"
					multiple="true" /></td>
				<td><form:errors path="javaSkills" cssClass="error" />
				</td>
			</tr>
			<form:hidden path="secretValue" />--%>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr> 
		</table>
	</form:form>
</body>
</html>
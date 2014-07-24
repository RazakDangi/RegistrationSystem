<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>View</h2>  
  
<table border="1">  
<tr>  
  <th>Id</th>  
  <th>Name</th>  
  <th>State</th> 
  <th>Country</th>
  <th>occupation</th>
</tr>  
 <c:forEach var="row" varStatus="loop" items="${cList}">  
      <tr>  
  <td>${row.customerId}</td>  
  <td>${row.name}</td>  
  <td>${row.state}</td> 
  <td>${row.country}</td>  
  <td>${row.occupation}</td>  
      </tr>  
 </c:forEach>  
</table>  
  
<p />  
  
Created by Pas Apicella  
</body>
</html>
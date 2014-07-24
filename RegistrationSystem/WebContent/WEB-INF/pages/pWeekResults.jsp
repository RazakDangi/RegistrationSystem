<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Last Week Details</title>
</head>
<body>

<h2>Last Week Details Summary</h2>  
  
<table border="1">  
<tr>  
  <th>No of people registered :</th>  
  <th>No of people from different states:</th>  
  <th>No of people from different countries </th>  
</tr>  
      <tr>  
  <td><c:out value="${lwCustomerDetails.totalCount}">${lwCustomerDetails.totalCount}</c:out></td>  
  <td>${lwCustomerDetails.statesCount}</td>  
  <td>${lwCustomerDetails.countriesCount }</td> 
 
   </tr>  
 
</table>  
  
<p />  
 
</body>
</html>
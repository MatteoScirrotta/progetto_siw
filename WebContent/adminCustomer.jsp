<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body style="background-color: yellow">
<f:view>
<table>
		<tr><th>Customer id</th><th>Customer's firstname</th><th>Customer's lastname</th><th>Customer's phonenumber</th><th>Customer's birth date</th><th>Customer's registration date</th><tr>
			<tr><td>${customerController.customer.id}</td>
				<td>${customerController.customer.firstname}</td>
				<td>${customerController.customer.lastname}</td>
				<td>${customerController.customer.phoneNumber}</td>
				<td>${customerController.customer.dateOfBirth}</td>
				<td>${customerController.customer.registrationDate}</td>
			</tr>
</table>
<h1></h1>
<h1></h1>

<table>
			<tr><th><FONT size=6><em>Customer's address</em></FONT></th></tr>
				<tr><td><FONT size=4>${customerController.addressToString}</FONT></td>
			</tr>
</table>
<c:choose>
	<c:when test="${orderController.isOpenOrder}">
		<a href='<c:url value="/faces/openOrders.jsp" />'>Go back</a>
	</c:when>
	<c:otherwise> 
		<h:form>
			<h:commandButton action="#{orderController.listOrders}" value="Go back" />
		</h:form>
	</c:otherwise>	
</c:choose>
</f:view>
</body>
</html>
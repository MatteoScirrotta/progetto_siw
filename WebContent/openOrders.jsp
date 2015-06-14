<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body style="background-color: LIGHTGOLDENRODYELLOW">
<f:view>
<h:form>
	<table>
		<tr><th>Order id</th><th>Order state</th><th>Order total</th><th>Action</th><th>      </th><th>Customer id</th><th>Action</tr>
			<c:forEach var="order" items="#{orderController.openOrders}" >
			<tr><td>${order.id}</td>
				<td>${order.state}</td>
				<td>${order.total}</td>
				<td><h:commandButton value="Check if the system can escape this order" action="#{orderController.checkAvailabilityOrder(order)}" /></td>
				<td>  <FONT color="yellow"> ______________ </FONT>    </td>
				<td>${order.customer.id}</td>
				<td><h:commandButton value="Customer details" action="#{customerController.findCustomer(order.customer)}" /></td>
			</tr>
			</c:forEach>
	</table>
	<h:commandButton value="Go Home" action="#{orderController.goAdminHome}" />
</h:form>
</f:view>
</body>
</html>
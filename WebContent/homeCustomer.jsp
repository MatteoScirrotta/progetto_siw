<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="it.uniroma3.beanController.CustomerController"%>
<%@page import="it.uniroma3.model.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home</title>
</head>
<body style="background-color: MISTYROSE">
<f:view>
<h1>${customerController.customer.firstname}'s home </h1>
<h2>${customerController.customer.address.city}, ${customerController.customer.address.street}, ${customerController.customer.address.streetNumber}</h2>
<h:form>
<table>
	<tr><th>Orders id</th><th>Orders state</th></tr>
		<c:forEach var="order" items="#{customerController.customer.orders}" > 
		<tr><td>
		<h:commandLink action="#{orderController.findOrder(order)}" value="#{order.id}">   
		</h:commandLink>
		</td><td>${order.state}</td></tr>
	</c:forEach>
</table>
<h:commandLink action="#{orderController.createOrder(customerController.customer)}" value="new order" />
<h2>  </h2>
<h:commandButton action="#{customerController.logout}" value="Logout" />

</h:form>
</f:view>
</body>
</html>
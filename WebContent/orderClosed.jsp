<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ORDER N. ${orderController.order.id} CLOSED</title>
</head>
<body style="background-color: LIGHTGOLDENRODYELLOW">
<f:view>
<h1>Order ${orderController.order.id} was closed properly</h1>

<h2>				Great job !!!</h2>

<h:form>
<h:commandButton value="List of all open orders" action="#{orderController.findOpenOrders}" />
</h:form>
</f:view>
</body>
</html>
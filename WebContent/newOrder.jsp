<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>NEW ORDER</title>
</head>
<c:choose>
	<c:when test="${adminController.log}">
<body style="background-color: yellow">
	</c:when>
	<c:when test="${customerController.log}">
<body style="background-color: MISTYROSE">
	</c:when>
	<c:otherwise>
<body>
	</c:otherwise>
</c:choose>
<h1><em>Complete your order </em></h1>
<f:view>
<h:form>
<h1>Your current order  </h1>
<c:forEach var="orderLine" items="#{orderController.order.orderLines}">
		<ul>
		<li><div>${orderLine.product.name}, unitPrice = ${ orderLine.unitPrice}, quantity = ${orderLine.quantity}</div></li>
		 </ul>
		</c:forEach>
<h2>add products you enjoy to complete your order</h2>
<h:commandLink action="#{productController.listProducts}"  value="Catalog" />
<h2>           </h2>

	<div><h:commandButton action="#{orderController.terminateOrder}" value="send order" /></div>
<h2>       </h2>
<a href='<c:url value="/faces/homeCustomer.jsp" />'>Home</a>
</h:form>
</f:view>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Order ${orderController.order.id }</title>
</head>
<c:choose>
	<c:when test="${adminController.log}">
<body style="background-color: LIGHTGOLDENRODYELLOW">
	</c:when>
	<c:when test="${customerController.log}">
<body style="background-color: MISTYROSE">
	</c:when>
	<c:otherwise>
<body>
	</c:otherwise>
</c:choose>
<div><h1><c:if test="${customerController.log}">
YOUR </c:if>ORDER DETAILS</h1></div>
<f:view>
<h:form>
<table>
	<tr><th>Order id</th><th>Order state</th><th>Order total</th><th>---Data order creation---</th><th>---Closed time---</th></tr>
	<tr><td>${orderController.order.id }</td>
		<td>${orderController.order.state}</td>
		<td>${orderController.order.total}</td>
		<td>${orderController.order.creationTime}</td>
		<td>${orderController.order.terminationTime}</td>
	</tr>
</table>
<h2>  </h2>
<h2> Products in<c:if test="${customerController.log}"> your</c:if><c:if test="${adminController.log}"> this</c:if> order </h2>
<table>
	<tr><th>Product name</th><th>Quantity ordered--</th><th> __Unit price</th></tr>
	<c:forEach var="orderLine" items="#{orderController.order.orderLines}" > 
		<tr><td>
		<h:commandLink action="#{orderController.getProduct(orderLine)}" value="#{orderLine.product.name}">   
		</h:commandLink></td>
		<td> __${orderLine.quantity}</td>
		<td>  ${orderLine.unitPrice}</td>
		</tr>
	</c:forEach>
</table>
<h1>  </h1>
<h1>   </h1>
<c:if test="${orderController.isOpenOrder}">
	<c:choose>
		<c:when test="${orderController.availability}"><h:commandButton value="Close this order and update quantity in stock" action="#{orderController.closeOrder}" /></c:when>
		<c:otherwise> <STRONG>System can't close this order, quantity in stock is not enough ! </STRONG></c:otherwise>
	</c:choose>
</c:if>
<h1> </h1>
<c:choose>
	<c:when test="${orderController.isOpenOrder}">
		<a href='<c:url value="/faces/openOrders.jsp" />'>Come back to open orders list</a>
	</c:when>
	<c:when test="${adminController.log}">
		<h:commandButton action="#{orderController.listOrders}" value="Go back to list of all orders" />
	</c:when>
	<c:when test="${customerController.log}">
		<h:commandButton action="#{customerController.goBack}" value="Go back" />
	</c:when>
</c:choose>
</h:form>
</f:view>
</body>
</html>
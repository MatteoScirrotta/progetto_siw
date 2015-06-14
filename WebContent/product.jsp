<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<c:choose>
	<c:when test="${adminController.log}">
<body style="background-color: LIGHTGOLDENRODYELLOW">
	</c:when>
	<c:when test="${customerController.log}">
<body style="background-color: MISTYROSE">
	</c:when>
	<c:otherwise>
<body style="background-color: LEMONCHIFFON">
	</c:otherwise>
</c:choose>
<f:view>
<h1>${productController.product.name}</h1> 
<h2>Details</h2>
<div>Id: ${productController.product.id}</div>
<div>Code: ${productController.product.code}</div>
<div>Unit Price: ${productController.product.price}</div>
<div>Description: ${productController.product.description}</div>
<div>Availability: ${productController.product.inStock}</div>

<c:if test="${customerController.log}">
<h:form>
<div>Quantity to order*: <h:inputText value="#{orderController.quantity}" 
                     required="true"
                     requiredMessage="quantity is mandatory"
                     converterMessage="this field must be a number"
                     id="quantity"
                     validatorMessage="minimum=1 maximum=availability value">
                     <f:validateLongRange maximum="#{productController.product.inStock }" minimum="1" /> </h:inputText>
                      <h:message for="quantity" style="color:red" />
                    
                     
<h:commandLink action="#{orderController.addOrderLine(productController.product)}" value="  Add this product to your shopping cart !" /></div>
</h:form>
</c:if>

<h:form>
<div><h:commandButton action="#{productController.listProducts}" value="Catalog" /></div>
</h:form>

</f:view>
</body>
</html>
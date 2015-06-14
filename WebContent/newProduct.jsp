<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Product</title>
</head>
<body style="background-color: LIGHTGOLDENRODYELLOW">
	<f:view>
		<h:form>
			<div>
				Title:
				<h:inputText value="#{productController.title}" required="true"
					requiredMessage="Name is mandatory" id="name" />
				<h:message for="name" />
			</div>
			<div>
				Code:
				<h:inputText value="#{productController.code}" required="true"
					requiredMessage="Code is mandatory" id="code" />
				<h:message for="code" />
			</div>
			<div>
				Price:
				<h:inputText value="#{productController.price}" required="true"
					requiredMessage="Price is mandatory"
					converterMessage="Price must be a number" id="price" />
				<h:message for="price" />
			</div>
			<div>
				Availability:
				<h:inputText value="#{productController.inStock}" required="true"
					requiredMessage="Quantity in stock is mandatory"
					converterMessage="Availability must be a natural number"
					id="availability" />
				<h:message for="availability" />
			</div>
			<div>
				Description:
				<h:inputTextarea value="#{productController.description}"
					required="false" cols="20" rows="5" />

			</div>
			<div>
				Author:
				<h:inputText value="#{productController.author}" required="true"
					requiredMessage="Author is mandatory" id="author" />
				<h:message for="author" />
			</div>
			<div>
				Genre:
				<h:inputText value="#{productController.genre}" required="true"
					requiredMessage="Genre is mandatory" id="genre" />
				<h:message for="genre" />
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{productController.checkData}" />
			</div>
		</h:form>
		<h:form>
			<h:commandLink action="#{productController.listProducts}"
				value="List all Products" />
			<div>
				<a href='<c:url value="/faces/adminHome.jsp" />'>Go home</a>
			</div>
		</h:form>
	</f:view>
</body>
</html>
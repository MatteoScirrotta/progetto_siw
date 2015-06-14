<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body style="background-color: LIGHTGOLDENRODYELLOW">
<f:view>
<h:form>
<h1>Complete the following fields</h1>
<h2> Fields marked with '*' are mandatory</h2>
<div>City*: <h:inputText value="#{providerController.city}" 
                     required="true"
                     requiredMessage="city is mandatory"
                     id="city"/> <h:message for="city" /></div>
<div>Street*: <h:inputText value="#{providerController.street}" 
                     required="true"
                     requiredMessage="Street is mandatory"
                     id="street"/> <h:message for="street" /></div>
<div>Street Number*: <h:inputText value="#{providerController.streetNumber}" 
                     required="true"
                     requiredMessage="Street number is mandatory"
                     id="streetNumber"/> <h:message for="streetNumber" /></div>
<div>Country: <h:inputText value="#{providerController.country}" 
                     required="false" />
                     </div>
<div>State*: <h:inputText value="#{providerController.state}" 
                     required="true"
                     requiredMessage="State is mandatory"
                     id="state"/> <h:message for="state" /></div>
<div>Zipcode*: <h:inputText value="#{providerController.zipcode}" 
                     required="true"
                     requiredMessage="Zipcode is mandatory"
                     id="zipcode"/> <h:message for="zipcode" /></div>
<div>		<h:commandButton value="Forward"  action="#{providerController.createAddress}"/></div>
</h:form>
</f:view>
</body>
</html>
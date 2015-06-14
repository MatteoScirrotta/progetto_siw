<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
 <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LOGIN</title>
</head>
<body style="background-color: LEMONCHIFFON">
<f:view>
<h1>Insert your credentials</h1>
<h:form>
  <div>Email: <h:inputText value="#{customerController.email}" 
                     required="true"
                     requiredMessage="email is mandatory"
                     id="email"/> <h:message for="email" />
                     </div>
<div>Password: <h:inputSecret value="#{customerController.password}" 
                     required="true"
                     requiredMessage="password is mandatory"
                     id="password"/> <h:message for="password" />
                     </div>
<div>
		<h:commandButton value="Submit"  action="#{customerController.checkLogin}"/>
		
</div>
<div><a href='<c:url value="/faces/newCustomer.jsp" />'>Are you a new customer? Register now !!!</a></div>
</h:form>
</f:view>  
</body>
</html>
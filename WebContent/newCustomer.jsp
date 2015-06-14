<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>BECOME A SUPERMARKET USER</title>
</head>
<body style="background-color: LEMONCHIFFON">
<f:view>
<h:form>
<h1>Register your self</h1>
<h2> Fields marked with '*' are mandatory</h2>
<div><em>Email</em>*: <h:inputText value="#{customerController.email}" 
                     required="true"
                     requiredMessage="Email is mandatory"
                     id="email"/> <h:message for="email" />    you will use your email to enter in your account</div>
<div><em>Password</em>*: <h:inputText value="#{customerController.password}" 
                     required="true"
                     requiredMessage="Password is mandatory"
                     id="password"/> <h:message for="password" />    you will use your password to enter in your account</div>
<div>Firstname*: <h:inputText value="#{customerController.firstname}" 
                     required="true"
                     requiredMessage="Firstname is mandatory"
                     id="firstname"/> <h:message for="firstname" /></div>
<div>Lastname*: <h:inputText value="#{customerController.lastname}" 
                     required="true"
                     requiredMessage="Lastname is mandatory"
                     id="lastname"/> <h:message for="lastname" /></div>
<div>Year of birth*: <h:inputText value="#{customerController.year}" 
                     required="false" 
                     requiredMessage="Year is mandatory"
                     id="yaer"/> <h:message for="year" />
        Month of birth*: <h:inputText value="#{customerController.month}" 
                     required="false" 
                     requiredMessage="Mounth is mandatory"
                     id="month"
                     validatorMessage="minimum=1 maximum=12">
                     <f:validateLongRange maximum="12" minimum="1" />
                     </h:inputText>
                      <h:message for="month" />
        Day of birth*: <h:inputText value="#{customerController.day}" 
                     required="false" 
                     requiredMessage="Day is mandatory"
                     id="day"
                     validatorMessage="minimum=1 maximum=31">
                     <f:validateLongRange maximum="31" minimum="1" />
                     </h:inputText>
                      <h:message for="day" />
</div>
<div>Phone number*: <h:inputText value="#{customerController.phoneNumber}" 
                     required="true"
                     requiredMessage="Phone number is mandatory"
                     id="phoneNumber"/> <h:message for="phoneNumber" /></div>
                     
<div>		<h:commandButton value="Forward"  action="#{customerController.goForward}"/></div>
<div><a href='<c:url value="/faces/index.jsp" />'>Go back</a></div>

</h:form>
</f:view>
</body>
</html>
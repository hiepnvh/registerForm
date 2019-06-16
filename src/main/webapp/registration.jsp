<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>


<div class="container">
	<h2>Registration</h2>
	<div class="mask ${res ?'' : 'hide' }"></div>
    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <spring:bind path="mobileNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="mobileNumber" class="form-control" placeholder="Mobile number"
                            autofocus="true"></form:input>
                            <form:errors path="mobileNumber" class="err-popover"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                
                <form:input type="text" path="firstName" class="form-control" placeholder="First name"
                            autofocus="true"></form:input>
                            <form:errors path="firstName" class="err-popover"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="Last name"
                            autofocus="true"></form:input>
                            <form:errors path="lastName" class="err-popover"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="dateOfBirth">
        <div class='form-group'>
        	<label>Date of birth</label><br>
        	<form:input type="text" id="date" path="dateOfBirth" data-format="DD-MM-YYYY" data-template="D MMM YYYY" name="date" class="form-control"></form:input>
             </div>
        </spring:bind>
        
        <spring:bind path="gender">
            <div class="form-group">
            	<label class="radio-inline">
			      <input path="gender" type="radio" name="gender" value="1" checked>Male
			    </label>
			    <label class="radio-inline">
			      <input path="gender" type="radio" name="gender"  value="0">Female
			    </label>
            </div>
        </spring:bind>
        
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email" class="form-control" placeholder="Email"
                            autofocus="true"></form:input>
                            <form:errors class="err-popover" path="email"></form:errors>
            </div>
        </spring:bind>
        
        <button class="btn btn-lg btn-block buble-color" type="submit">Submit</button>
    </form:form>
    
</div>
<!-- /container -->
<script src="${contextPath}/resources/js/lib/jquery.min.js"></script>
<script src="${contextPath}/resources/js/lib/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/lib/combodate.js"></script>
<script src="${contextPath}/resources/js/lib/moment.min.js"></script>
<script src="${contextPath}/resources/js/App.js"></script>
</body>
<footer>
	<div class="container">
		<div class="buble-color ${!res ?'' : 'hide' }"></div>
	  	<a href="/login" class="btn btn-lg btn-block buble-color ${res ?'' : 'hide' }" type="submit">Login</a>
	</div>
</footer>
</html>

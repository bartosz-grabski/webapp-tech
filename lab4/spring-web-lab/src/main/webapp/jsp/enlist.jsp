<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
<head>
    <title>Create new transaction</title>
</head>
<body>

<form:form commandName="command" method="post"
           action="${pageContext.request.contextPath}/user/transactions/enlist"
           role="form">

    <h3>
        Create new transaction:
    </h3>

    <div class="form-group">
        <form:label path="accountNumber">Account Number</form:label>
        <form:input path="accountNumber" class="form-control"
                    placeholder="Type account number in here"/>

        <form:label path="transactionValue">Account Number</form:label>
        <form:input path="transactionValue" class="form-control"
                    placeholder="Type transaction value in here"/>
    </div>
    <button type="submit" class="btn btn-default">Save</button>
</form:form>

</body>
</html>

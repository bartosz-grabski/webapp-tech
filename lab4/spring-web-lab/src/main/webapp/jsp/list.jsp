<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
<head>
    <title>List all transactions</title>
</head>
<body>

<h3>Transaction list:</h3>
<table class="table table-hover">
    <tr>
        <th>Account Number</th>
        <th>Data</th>
        <th>Vallue</th>
        <th>Data</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${transactions}" var="transaction">

        <tr>
            <td><c:out value="${transaction.accountNumber}"/></td>
            <td><c:out value="${transaction.transactionDate}"/></td>
            <td><c:out value="${transaction.transactionValue}"/></td>
        </tr>

    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/user/transactions/enlist">Enlist new transaction</a>


</body>
</html>

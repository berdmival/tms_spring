<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="/pages/head.jsp" %>
<body>
<h1>Enter numbers and select action. Then click "Calculate".</h1>

<c:if test="${requestScope.history.size() > 0}">
    <table border="1">
        <caption><h2>History:</h2></caption>
        <tr>
            <th>Date</th>
            <th>Number 1</th>
            <th>Number 2</th>
            <th>Action</th>
            <th>Result</th>
        </tr>
        <c:forEach var="historyItem" items="${requestScope.history}">
            <tr>
                <td>${historyItem.calcDateTime}</td>
                <td>${historyItem.num1}</td>
                <td>${historyItem.num2}</td>
                <td>${historyItem.actionType}</td>
                <td>${historyItem.result}</td>
            </tr>
        </c:forEach>
    </table>
    <hr size="2" color="black">
</c:if>
<c:if test="${requestScope.history.size() == 0}">
    <h2>History is empty</h2>
</c:if>

<h2>Current result: <c:out value="${requestScope.message}"/></h2>

<spring:form action="/calc" method="post" modelAttribute="expression">
    <spring:input autofocus="true" placeholder="num1" type="number" step="any" path="num1"/>
    <spring:errors path="num1"/>

    <spring:select path="actionType">
        <c:forEach items="${possibleActions}" var="actionItem">
            <spring:option value="${actionItem}">${actionItem.actCode}</spring:option>
        </c:forEach>
    </spring:select>
    <spring:errors path="actionType"/>

    <spring:input placeholder="num2" type="number" name="num2" step="any" path="num2"/>
    <spring:errors path="num2"/>

    <spring:button>Calculate</spring:button>
</spring:form>
<a class="btn" href="${pageContext.request.contextPath}/">Home</a>
<a class="btn" href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>

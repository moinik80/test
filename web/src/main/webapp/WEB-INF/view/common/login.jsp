<%--tales fith lofen dates--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/j_spring_security_logout" var="logoutUrl" />

<div id = "user"><spring:message code="page.login"/> <a href="/profile.form">${sessionScope.person.fio}</a><br/>
    <a href="${logoutUrl}"><spring:message code="page.log_out"/></a>
</div>
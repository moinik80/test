<%--page with list users--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="login">

    <%--message login error--%>
    <h5>${error}</h5>

    <%--authorisation form--%>
        <spring:url var="authUrl" value="/j_spring_security_check" />
    <form method = "post" action = "${authUrl}">
    <%--<form method = "post" action = "/welcome.form">--%>
        <input type = "hidden" name = "page" value = "Login"/>
        <fieldset>
            <legend><spring:message code="page.log_in"/></legend>
            <div>
                <input name = "j_username" type = "text"/><br/>
                <input name = "j_password" type = "password"/><br/>
                <input id = "login_submit" type = "submit" value = "Login"/>
            </div>
        </fieldset>
    </form>
</div>

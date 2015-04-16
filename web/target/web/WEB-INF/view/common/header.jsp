<%--tiles with header--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <div id="head">
        <h1><spring:message code="page.header_message"/></h1>
        <span>
            <a href="/index.form?locale=en">en</a>
            |
            <a href="/index.form?locale=ru">ru</a>
        </span>
    </div>


<%--select count results in page--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<select name="countResult">
    <c:if test="${countResult eq '5'}">
        <option value="5" selected="selected">5</option>
        <option value="10">10</option>
        <option value="20">20</option>
    </c:if>
    <c:if test="${countResult eq '10'}">
        <option value="5">5</option>
        <option value="10" selected="selected">10</option>
        <option value="20">20</option>
    </c:if>
    <c:if test="${countResult eq '20'}">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="20" selected="selected">20</option>
    </c:if>
</select>
<div></div>

<%--person profile--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="content">
    <h3>Профиль пользователя</h3></br>
    <table id="output" align="center">
        <tr class="t_head">
            <td><spring:message code="page.profile.fio"/> </td>
            <td>email</td>
            <td><spring:message code="page.table_status"/> </td>

        </tr>
        <tr class="t_row">
            <td>${sessionScope.person.fio}</td>
            <td>${sessionScope.person.email}</td>
            <td>
                <c:if test="${sessionScope.person.role eq 'admin'}">
                    Администратор
                </c:if>
                <c:if test="${sessionScope.person.role eq 'user'}">
                    Читатель
                </c:if>
            </td>
        </tr>
    </table>
</div>
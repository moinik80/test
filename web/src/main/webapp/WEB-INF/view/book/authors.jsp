<%--page with list authors--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <div id="content">
        <table class="output" align="center">
            <tr class="t_head">
                <td>№</td>
                <td><spring:message code="page.table_author"/> </td>
            </tr>
            <c:forEach var="i" begin="0" end="${authors.size() - 1}">
                <tr class="t_row">
                    <td>${i + 1}</td>
                    <td>${authors[i]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

<%--select icons for sorting--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${sortFlag eq 'up'}">
    <img src="../../../assests/img/sort_down.png" class="img_sort"/>
</c:if>
<c:if test="${sortFlag eq 'down'}">
    <img src="../../../assests/img/sort_up.png" class="img_sort"/>
</c:if>
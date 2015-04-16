<%--for navigation--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${sortFlag eq 'down'}">
    <input type="hidden" name="sortFlag" value="up">
</c:if>
<c:if test="${sortFlag eq 'up'}">
    <input type="hidden" name="sortFlag" value="down">
</c:if>

<input type="submit" value="<<" name="navBtn"/>
<input type="submit" value="<" name="navBtn"/>
<input type="text" value="${pageNumber}" name="pageNumber"/>
<input type="submit" value=">" name="navBtn"/>
<input type="submit" value=">>" name="navBtn"/>
<br/>
<input type="submit" value="Переход" name="navBtn"/><br/>
<h5>Всего страниц: ${countPages}</h5>
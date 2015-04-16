<%--page book informations--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="content">
    <h3>${book.bookName}</h3>
    <table style="font-size: 12px; margin: 5px">
        <tr>
            <td>
                <img src="${book.pathImg}" style="padding: 10px">
            </td>
            <td>
                <div style="text-align: justify; vertical-align: text-top">
                    <h5>Автор: </h5>
                    ${book.bookAuthor}
                    <br>
                    <div></div>
                    <h5>Описание: </h5>
                    ${book.bookDescription}
                </div>
            </td>
        </tr>
    </table>
</div>
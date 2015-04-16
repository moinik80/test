<%--page with list books--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="content">
    <form action="/books/${sortRow}/${sortFlag}.form" method="post" id="pagination">

        <input type="hidden" value="true" name="pagination">

        <%--include select count result--%>
        <%@ include file="../includedPages/selectCountResultInpage.jsp"%>

            <table class="output" align="center">

                <%--button for redirect to form "add book" (only for admin)--%>

                    <sec:authorize access="hasRole('admin')">
                        <tr>
                            <td style="background-color: #ffffff; height: 40px">
                                <a href="/books/add.form" style="text-decoration: none">
                                    <img src="../../../assests/img/add.png"/>
                                </a>
                            </td>
                        </tr>
                    </sec:authorize>

                <tr class="t_head">
                    <td>№</td>
                    <td>
                        <a href="${linkBooks}" class = "sort">
                            <div>
                                <spring:message code="page.table_book"/>
                                <c:if test="${sortRow eq 'authors'}">
                                    <%--included sort-icons--%>
                                    <%@include file="../includedPages/sortsImg.jsp"%>
                                </c:if>
                            </div>
                        </a>
                    </td>
                    <td>
                        <a href="${linkAuthors}" class = "sort">
                            <div>
                                <spring:message code="page.table_author"/>
                                <c:if test="${sortRow eq 'books'}">
                                    <%--included sort-icons--%>
                                    <%@include file="../includedPages/sortsImg.jsp"%>
                                </c:if>
                            </div>
                        </a>
                    </td>
                </tr>
                <c:forEach var="i" begin="0" end="${books.size() - 1}">
                    <tr class="t_row">
                        <td>${i + 1}</td>
                        <td>
                            <a href="/book/${books[i].bookId}.form">
                                    ${books[i].bookName}
                            </a>
                        </td>
                        <td>${books[i].bookAuthor}</td>

                        <%--added button 'edit' and delete (only for admin)--%>
                        <sec:authorize access="hasRole('admin')">
                            <td style="background-color: #ffffff">
                                <a href="/books/edit/${books[i].bookId}.form" style="text-decoration: none;">
                                    <img src="../../../assests/img/edit.png"/>
                                </a>
                            </td>
                            <td style="background-color: #ffffff">
                                <a href="/books/del/${books[i].bookId}.form" style="text-decoration: none;">
                                    <img src="../../../assests/img/del.png"/>
                                </a>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </table>
            <div></div>
                <%--include navigation for pagination1--%>
            <%@ include file="../includedPages/navigationForPagination.jsp"%>
            </form>
        </div>


<%--add book--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="content">
    <form action="/book/add.form" method="post">
        <table align="center" valign="top" style="font-size: 12px";>
            <tr>
                <td align="right">Название</td>
                <td align="left">
                    <input type="text" name="bookName">
                </td>
            </tr>
            <tr>
                <td align="right">Автор</td>
                <td align="left">
                    <input type="text" name="bookAuthor">
                </td>
            </tr>
            <tr>
                <td align="right">Аннотация</td>
                <td align="left">
                        <textarea name="bookDescription">

                    </textarea>
                </td>
            </tr>
            <tr>
                <td align="right">Категории</td>
                <td align="left">
                    <select name="bookCategory1">
                        <c:forEach var="i" begin="0" end="${categories.size() - 1}">
                            <option value="${categories[i].categoryId}">
                                    ${categories[i].categoryName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <select name="bookCategory2">
                        <c:forEach var="i" begin="0" end="${categories.size() - 1}">
                            <option value="${categories[i].categoryId}">
                                    ${categories[i].categoryName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">Текст книги</td>
                <td align="left">
                        <textarea name="bookText">

                        </textarea>
                </td>
            </tr>
            <tr>
                <td align="right">адрес картинки</td>
                <td align="left">
                    <input type="text" name="imgPath">
                </td>
            </tr>
        </table>
        <input type="submit" value="Добавить">
    </form>
</div>

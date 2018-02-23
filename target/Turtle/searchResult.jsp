<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>houses</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<c:out value="${user.name}"/>
<c:out value="${user.balance}"/>
<table>
    <c:forEach items="${houses}" var="house">
        <thead>
        <tr>
            <th>متراژ</th>
            <th>نوع</th>
            <c:if test="${house.dealType == 0}">
                <th>قیمت فروش</th>
            </c:if>
            <c:if test="${house.dealType == 1}">
                <th>
                    قیمت اجاره
                </th>
            </c:if>
            <th>لینک عکس</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${house.area}</td>
            <c:if test="${house.dealType == 0}">
                <td>
                    فروش
                </td>
            </c:if>
            <c:if test="${house.dealType == 1}">
                <td>
                    اجاره
                </td>
            </c:if>
            <c:if test="${house.dealType == 0}">
                <td>
                        ${house.sellPrice}
                </td>
            </c:if>
            <c:if test="${house.dealType == 1}">
                <td>
                        ${house.rentPrice}
                </td>
            </c:if>
            <td><c:out value="${house.imageURL}" /></td>
            <td><form action="GetSingleHouse" method="post"><input name="id" type="hidden" value="${house.id}"><button type="submit">اطلاعات بیشتر</button></form></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
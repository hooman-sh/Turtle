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
    <tr>
        <th>نوع ساختمان</th>
        <th>نوع قرارداد</th>
        <c:if test="${house.dealType == 0}">
            <th>قیمت فروش</th>
        </c:if>
        <c:if test="${house.dealType == 1}">
            <th>
                قیمت اجاره
            </th>
        </c:if>
        <th>لینک عکس</th>
        <th>متراژ</th>
        <th>آدرس</th>
        <th>توضیحات</th>
        <th>#</th>
    </tr>

    <tr>
        <td>${house.buildingType}</td>
        <c:if test="${house.dealType == 1}">
        <td>
            اجاره
        </td>
        </c:if>
        <c:if test="${house.dealType == 0}">
        <td>
            فروش
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
        <td><c:out value="${house.area}" /></td>
        <td><c:out value="${house.address}" /></td>
        <td><c:out value="${house.description}" /></td>
        <td><form action="PaymentServlet" method="post"><input name="id" type="hidden" value="${house.id}"><button type="submit">مشاهده تلفن</button></form></td>
    </tr>
</table>
<c:if test="${text == '-'}">
    <c:if test="${house.phone == ''}">
        <p>
                این خانه توسط بنگاه ثبت شده
        </p>
    </c:if>
    <c:if test="${house.phone != ''}">
        <p>
                ${house.phone}
        </p>
    </c:if>
</c:if>
<c:if test="${text == 'اعتبار شما کافی نیست'}">
    <p>
        اعتبار شما کافی نیست
    </p>
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>search</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<c:out value="${user.name}"/>
<c:out value="${user.balance}"/>
<form action="SearchServlet" method="post" accept-charset="UTF-8">
    minArea : <input type="text" name="minArea"> <BR>
    dealType : <input type="text" name="dealType"> <BR>
    buildingType : <input type="text" name="buildingType"> <BR>
    maxPrice : <input type="text" name="maxPrice"> <BR>
    <input type="submit" />
</form>
<form action="HouseServlet" method="post" accept-charset="UTF-8">
    Area : <input type="text" name="area"> <BR>
    dealType : <input type="text" name="dealType"> <BR>
    buildingType : <input type="text" name="buildingType"> <BR>
    Price : <input type="text" name="price"> <BR>
    Phone : <input type="text" name="phone"> <BR>
    description : <input type="text" name="description"> <BR>
    address : <input type="text" name="address"> <BR>
    <input type="submit" />
</form>
<form action="CreditServlet" method="post">
    افزایش اعتبار :  <BR>
    <input type="text" name="value">
    <input type="submit" />
</form>
<c:if test="${text == 'success'}">
    <p>موفقیت</p>
</c:if>
<c:if test="${text == 'err'}">
    <p>عدم موفقیت</p>
</c:if>
<c:if test="${house_text == 'success'}">
    <p>موفقیت</p>
</c:if>
<c:if test="${house_text == 'err'}">
    <p>عدم موفقیت</p>
</c:if>
</body>
</html>
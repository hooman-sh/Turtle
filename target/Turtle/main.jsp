<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>search</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body style="text-align: right">
<c:out value="${user.name}"/>
<c:out value="${user.balance}"/>
<form action="SearchServlet" method="post" accept-charset="UTF-8">
     حداقل متراژ : <input type="text" name="minArea"> <BR>
    نوع قرارداد : <input type="text" name="dealType"> <BR>
    نوع ساختمان : <input type="text" name="buildingType"> <BR>
    ماکسیمم قیمت : <input type="text" name="maxPrice"> <BR>
    <input type="submit" />
</form>
<form action="HouseServlet" method="post" accept-charset="UTF-8">
    متراژ : <input type="text" name="area"> <BR>
    نوع قرارداد : <input type="text" name="dealType"> <BR>
    نوع ساختمان : <input type="text" name="buildingType"> <BR>
    قیمت : <input type="text" name="price"> <BR>
    شماره : <input type="text" name="phone"> <BR>
    توضیح : <input type="text" name="description"> <BR>
    آدرس : <input type="text" name="address"> <BR>
    <input type="submit" />
</form>
<form action="CreditServlet" method="post">
    افزایش اعتبار :  <BR>
    <input type="text" name="value">
    <input type="submit" />
</form>
<c:if test="${text == 'success'}">
    <p style="background-color: greenyellow"> افزایش اعتبار موفق </p>
</c:if>
<c:if test="${text == 'err'}">
    <p style="background-color: red">عدم موفقیت</p>
</c:if>
<c:if test="${house_text == 'success'}">
    <p style="background-color: greenyellow"> خانه جدید اضافه شد</p>
</c:if>
<c:if test="${house_text == 'err'}">
    <p style="background-color: red">عدم موفقیت</p>
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>search</title>
</head>
<body>
Welcome ${requestScope['user'].getName()}.
<form action="SearchServlet" method="post">
    minArea : <input type="text" name="minArea"> <BR>
    dealType : <input type="text" name="dealType"> <BR>
    buildingType : <input type="text" name="buildingType"> <BR>
    maxPrice : <input type="text" name="maxPrice"> <BR>
    <input type="submit" />
</form>
<form action="HouseServlet" method="post">
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
    minArea : <input type="text" name="value"> <BR>
    <input type="submit" />
</form>
</body>
</html>
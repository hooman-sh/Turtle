<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>search</title>
</head>
<body>
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
</body>
</html>
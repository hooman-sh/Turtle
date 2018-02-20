<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>search</title>
</head>
<body>
<form action="SearchServlet" method="post">
    minArea : <input type="text" name="minArea"> <BR>
    dealType : <input type="text" name="dealType"> <BR>
    buildingType : <input type="text" name="buildingType"> <BR>
    maxPrice : <input type="text" name="maxPrice"> <BR>
    <input type="submit" />
</form>
</body>
</html>
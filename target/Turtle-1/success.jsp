<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%--<c:forEach var="j" begin="1" end="${requestScope['houses'].size()}">--%>
<%--Item <c:out value="${requestScope['houses'][j]}"/><p>--%>
<%--</c:forEach>--%>
Welcome ${requestScope['houses'].size()}.

</body>
</html>
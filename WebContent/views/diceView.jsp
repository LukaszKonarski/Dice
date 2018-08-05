<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Diceview</title>
<style type="text/css">
a,p {
display:block;
padding:5px;
}

</style>

</head>
<body>

<%
HttpSession sess = request.getSession();
Map<Integer, Integer> results = (Map<Integer, Integer>) sess.getAttribute("toss");
%>
<p><h3>Wylosowana wartość to: <%=request.getAttribute("currrentResult") %></h3></h3></p>
<p>Statystyki:</p>
<p>Wartość <b>1</b> wylosowano: <%=results.get(1) %></b> razy</p>
<p>Wartość <b>2</b> wylosowano: <%=results.get(2) %></b> razy</p>
<p>Wartość <b>3</b> wylosowano: <%=results.get(3) %></b> razy</p>
<p>Wartość <b>4</b> wylosowano: <%=results.get(4) %></b> razy</p>
<p>Wartość <b>5</b> wylosowano: <%=results.get(5) %></b> razy</p>
<p>Wartość <b>6</b> wylosowano: <%=results.get(6) %></b> razy</p>
<a href='dice'><label>Losuj ponownie</label></a>


</body>
</html>
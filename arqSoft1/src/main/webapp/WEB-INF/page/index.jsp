<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
         <title> Inicio </title>
         <meta name = "author" content = "blog de pan_junbiao">
</head>
<body>
 <h3> Utilice expresiones JSP: </h3>
 Nombre de usuario: <% = request.getAttribute ("name")%> <br/>
 Dirección del blog: <% = request.getAttribute ("blog")%> <br/>
 Comentarios: <% = request.getAttribute ("comment")%> <br/>
 
 <h3> Utilice el lenguaje de expresión EL: </h3>
 Nombre de usuario: $ {requestScope.name} <br/>
 Dirección del blog: $ {requestScope.blog} <br/>
 Comentarios: $ {requestScope.remark} <br/>
 
 <h3> Utilice la biblioteca de etiquetas JSTL: </h3>
 Nombre de usuario: <c: out value = "$ {requestScope.name}" /> <br/>
 Dirección del blog: <c: out value = "$ {requestScope.blog}" /> <br/>
 Comentarios: <c: out value = "$ {requestScope.remark}" /> <br/>
</body>
</html>
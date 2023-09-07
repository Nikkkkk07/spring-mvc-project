<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<table>
<c:forEach var="employee" items="${employeeList}"> 
	<tr>	
		<td>${employee.employeeId}</td>
		<td>${employee.employeeName}</td>
	</tr>
</c:forEach> 
</table>
</body>
</html>
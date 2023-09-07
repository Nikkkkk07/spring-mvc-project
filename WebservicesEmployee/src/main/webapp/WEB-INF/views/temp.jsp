<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<table>
<c:forEach var="employee" items="${list1}"> 
	<tr>	
		<td>${employee.id}</td>
		<td>${employee.name}</td>
	</tr>
</c:forEach> 
</table>
</body>
</html>
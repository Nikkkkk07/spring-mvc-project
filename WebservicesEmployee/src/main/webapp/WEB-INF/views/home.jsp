<html>
<body>
<form action="/showAll">
<button type="submit">Fetch All Employees</button>
</form>
<form action="/insertEmployee" method="post">
employeeId:<input type="text" name="employeeId"/><br/>
employeeName:<input type="text" name="employeeName"/><br/>
<button type="submit">Insert a Employee</button>
</form>
<form action="/updateEmployee">
<button type="submit">Updating a Employee</button>
</form>
<form action="/showById">
<button type="submit">Fetch Employee By Id</button>
</form>
<form action="/deleteById">
<button type="submit">Delete Employee By Id</button>
</form>
</body>
</html>
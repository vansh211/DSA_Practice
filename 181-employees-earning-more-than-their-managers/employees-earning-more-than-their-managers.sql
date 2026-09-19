SELECT name AS Employee
FROM Employee
WHERE salary > (
    SELECT salary
    FROM Employee m
    WHERE m.id = Employee.managerId
);
# Write your MySQL query statement below
SELECT FirstName, LastName, City, State from Person left join address on person.personid = address.personid

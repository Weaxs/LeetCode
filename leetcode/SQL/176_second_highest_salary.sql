# Write your MySQL query statement below
--编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
--
--+----+--------+
--| Id | Salary |
--+----+--------+
--| 1  | 100    |
--| 2  | 200    |
--| 3  | 300    |
--+----+--------+
--例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
--
--+---------------------+
--| SecondHighestSalary |
--+---------------------+
--| 200                 |
--+---------------------+

# 返回null使用临时表
select (select distinct Salary from Employee order by Salary desc limit 1 offset 1) as SecondHighestSalary

# 使用IFNULL函数 和 LIMIT 子句
SELECT IFNULL( (SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET 1), NULL) AS SecondHighestSalary
package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.service.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee-service.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		System.out.println(jdbcTemplate);

//		jdbcTemplate.update("insert into employee(employeeName,salary,emailId,password)values(?,?,?,?)", "james", 90,
//				"james@james.com", "1234");

		int id = 4;
		String sql = "select * from employee where employeeId= ?";

		Employee e = (Employee) jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper(Employee.class));

		System.out.println(e);

	}

}

//insert
// jdbcTemplate.update("insert into
// employee(employeeName,salary)values(?,?)", "sahzad",60);
/*
 * String sql="insert into employee(employeeName,salary)values(?,?)"; Object[]
 * data={"sahzad",60 }; jdbcTemplate.update(sql,data);
 */
/*
 * String sql="insert into employee(employeeName,salary)values(?,?)";
 * jdbcTemplate.update(sql,new Object[]{"sahzad",60});
 */
// update
// jdbcTemplate.update("update employee set salary = ? where employeeId
// = ?" , 80,3);
// delete
// jdbcTemplate.update("delete from employee where employeeName= ? and
// salary= ?","prabhat",30);
// select single row
/*
 * int id=3; String sql="select * from employee where employeeId= ?"; Employee
 * e=(Employee)jdbcTemplate.queryForObject(sql, new Object[]{id}, new
 * BeanPropertyRowMapper(Employee.class)); System.out.println(e);
 */

//select multiple rows
/*
 * String sql="select * from employee "; List<Employee> e=(List)
 * jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));
 * System.out.println(e);
 */

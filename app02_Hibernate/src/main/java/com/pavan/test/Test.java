package com.pavan.test;

import com.pavan.dao.*;
import com.pavan.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/pavan/resources/applicationContext.xml");
		EmployeeDao empDao = (EmployeeDao)context.getBean("empDao");
		
		//Insert Operation
	
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEsal(5000);
		emp.setEaddr("Hyderabad");
		
		String status = empDao.insert(emp);
		System.out.println(status);
		
	
/*		//Search Operation
		
		Employee emp = empDao.search(111);
		if(emp==null)
		{
			System.out.println("Employee Not Existed");
		}else {
			System.out.println("Employee Details");
			System.out.println("-------------------------");
			System.out.println("Employee Number : "+emp.getEno());
			System.out.println("Employee Name   : "+emp.getEname());
			System.out.println("Employee Salary : "+emp.getEsal());
			System.out.println("Employee Address: "+emp.getEaddr());
		}
*/		
		
/*		//UPdate operation
		
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEsal(15000);
		emp.setEaddr("Chennaiiiiiii");
		String status=empDao.update(emp);
		System.out.println(status);
*/
		
/*		//Deletion operation
		
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEsal(15000);
		emp.setEaddr("Chennaiiiiiii");
		String status=empDao.delete(emp);
		System.out.println(status);
*/
	}

}

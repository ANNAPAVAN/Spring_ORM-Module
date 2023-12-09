package com.pavan.dao;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.pavan.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public String insert(Employee emp) {
		String status="";
		try {
			Employee emp1 = (Employee)hibernateTemplate.get(Employee.class,emp.getEno());
			if(emp1!=null)
			{
				status = "Employee Existed Already";
			}else {
				int eno = (Integer)hibernateTemplate.save(emp);
				if(eno==emp.getEno())
				{
					status="Employee inserted Successfully";
				}else {
					status="Employee insertion Failure";
				}
			}
			
		}catch(Exception e) {
			status = "Employee insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Transactional
	public Employee search(int eno) {
		Employee emp=null;
		try{
			emp = (Employee)hibernateTemplate.get(Employee.class, eno);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Transactional
	public String update(Employee emp) {
		String status="";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1==null)
			{
				status="Employee Not Existed";
			}else {
				hibernateTemplate.evict(emp1);
				hibernateTemplate.update(emp);
				status="Employee Updation Success";
			}

			
		}catch(Exception e) {
			status="Employee Updation Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Transactional
	public String delete(Employee emp) {
		String status="";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1==null)
			{
				status="Employee Not Existed";
			}else {
				hibernateTemplate.evict(emp1);
				hibernateTemplate.delete(emp);
				status="Employee Deletion Success";
			}

			
		}catch(Exception e) {
			status="Employee Deletion Failure";
			e.printStackTrace();
		}
		return status;
	}

}

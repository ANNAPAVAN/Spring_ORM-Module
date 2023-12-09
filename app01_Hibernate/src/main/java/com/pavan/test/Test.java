package com.pavan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pavan.entity.Employee;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            Configuration cfg = new Configuration();
            cfg.configure("/com/pavan/resources/hibernate.cfg.xml");

            sessionFactory = cfg.buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();    //it is not required while retriving data
            
          //*********Insert Operation********
 
            Employee emp = new Employee();
            emp.setEno(111);
            emp.setEname("AAA");
            emp.setEsal(5000);
            emp.setEaddr("US");
            
            session.save(emp);//--->insert operation  //to reflect data into database
            transaction.commit();
            System.out.println("Employee Inserted Successfully");
            
 
/*            //***********Update Operation***************
            
            Employee emp = new Employee();
            emp.setEno(111);
            emp.setEname("AAA");
            emp.setEsal(7000);
            emp.setEaddr("HYD");
            
//            session.saveOrUpdate(emp); //if already existed update or else insert into table
            session.update(emp);
            transaction.commit();
            System.out.println("Employee Updated Successfully");
*/  
            
            
            
/*			//*********Delete Operation*********
 
            Employee emp = new Employee();
            emp.setEno(111);
            emp.setEname("AAA");
            emp.setEsal(7000);
            emp.setEaddr("HYD");
            
            session.delete(emp);
            transaction.commit();
            System.out.println("Employee Deleted Successfully");
*/            
            
            
            
/*            //******Retriving Operation
            
            Employee emp = (Employee) session.get("com.pavan.entity.Employee",111);  //fully qualified name , primary key
            System.out.println("Employee Details");
            System.out.println("-------------------------------");
            System.out.println("Employee Number : "+emp.getEno());
            System.out.println("Employee Name   : "+emp.getEname());
            System.out.println("Employee Salary : "+emp.getEsal());
            System.out.println("Employee Address: "+emp.getEaddr());
            System.out.println();
*/
            System.out.println("Transaction Success");
        } catch (Exception e) {
        	
        	//not required while Retriving data
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction Failure");
            }
 
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

}


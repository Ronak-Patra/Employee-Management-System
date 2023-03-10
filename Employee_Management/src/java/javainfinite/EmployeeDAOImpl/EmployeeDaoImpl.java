/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javainfinite.EmployeeDAOImpl;

import java.util.ArrayList;
import java.util.List;
import javainfinite.pojo.EmployeeDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class EmployeeDaoImpl {
    
    public void saveEmployee(EmployeeDetails employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public List<EmployeeDetails> showAllEmployees() {
        List<EmployeeDetails> employeeList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From EmployeeDetails");
        employeeList = query.list();
        return employeeList;
    }

    public void updateEmployee(int id, String ename, String enumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        EmployeeDetails empdetails = (EmployeeDetails)session.load(EmployeeDetails.class, id);
        empdetails.setEname(ename);
        empdetails.setEnumber(enumber);
        session.update(empdetails);
        transaction.commit();
        session.close();  
    }

    public void deleteEmployee(EmployeeDetails employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }
    
}

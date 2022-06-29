package com.maksgir.crud_mvc.dao;

import com.maksgir.crud_mvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionEventListener;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee ", Employee.class).getResultList();



        return employeeList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(employee.getId());
        if (employee.getId()==0){
            session.save(employee);
        } else {
            session.update(employee);
        }
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = session.get(Employee.class, id);
        session.delete(emp);
    }
}

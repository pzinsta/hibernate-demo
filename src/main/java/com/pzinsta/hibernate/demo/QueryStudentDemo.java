package com.pzinsta.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pzinsta.hibernate.demo.entity.Student;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            
            List<Student> students = session.createQuery("from Student", Student.class).list();
            
            students.stream().forEach(System.out::println);
            
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

}

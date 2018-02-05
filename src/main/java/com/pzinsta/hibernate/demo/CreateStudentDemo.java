package com.pzinsta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pzinsta.hibernate.demo.entity.Student;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = sessionFactory.getCurrentSession();
        
        try {
            Student student = new Student();
            student.setFirstName("John");
            student.setLastName("Smith");
            student.setEmail("john.smith@gmail.com");
            
            session.beginTransaction();
            
            session.save(student);
            
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

}

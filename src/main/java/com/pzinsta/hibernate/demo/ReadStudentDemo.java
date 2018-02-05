package com.pzinsta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pzinsta.hibernate.demo.entity.Student;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = sessionFactory.getCurrentSession();
        
        try {
            Student student = new Student();
            student.setFirstName("Jack");
            student.setLastName("Sparrow");
            student.setEmail("john.smith@gmail.com");
            
            session.beginTransaction();
            System.out.println(student);
            
            session.save(student);
            
            session.getTransaction().commit();
            
            System.out.println("generated id: " + student.getId());
            
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            System.out.println("getting student with id: " + student.getId());
            
            Student retrievedStudent = session.get(Student.class, student.getId());
            
            System.out.println(retrievedStudent);
            
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

}

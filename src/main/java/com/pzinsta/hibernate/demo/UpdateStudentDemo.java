package com.pzinsta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pzinsta.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        
        
        try {

            int studentID = 1;
            Session session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            System.out.println("getting student with id: " + studentID);
            
            Student student = session.get(Student.class, studentID);
            
            session.getTransaction().commit();
            
            
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            student.setFirstName("Bob");
            
            session.update(student);
            
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

}

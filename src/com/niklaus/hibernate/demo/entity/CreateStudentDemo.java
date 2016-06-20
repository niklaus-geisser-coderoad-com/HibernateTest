package com.niklaus.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by NiklausGeisser on 6/18/16.
 */
public class CreateStudentDemo {
    public static void main(String[]args){
        // Create session factory
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //Create a session
        Session session = factory.getCurrentSession();

        try{
            // Use the session object to save Java object

            // Create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Claudia","Vaquera","claudiavaqueram@gmail.com");

            //start transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {

        }
    }
}

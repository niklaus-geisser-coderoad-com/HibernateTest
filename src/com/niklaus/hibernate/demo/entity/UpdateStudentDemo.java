package com.niklaus.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by NiklausGeisser on 6/19/16.
 */
public class UpdateStudentDemo {
    public static void main(String[]args){
        // Create session factory
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //Create a session
        Session session = factory.getCurrentSession();

        try{

            int studentId = 1;
            //start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Get student
            Student myStudent = (Student) session.get(Student.class,studentId);

            System.out.println("Update");
            myStudent.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();

            //NEW CODE

            //Update by Query
            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("Updating email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            //Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {

        }
    }
}

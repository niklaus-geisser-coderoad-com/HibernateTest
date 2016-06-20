package com.niklaus.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by NiklausGeisser on 6/18/16.
 */
public class PrimaryKeyDemo {
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

            // Create 3 student objects
            System.out.println("Creating 3 student objects...");
            Student tempStudent = new Student("Jose","Miranda","jm@gmail.com");
            Student tempStudent2 = new Student("Alex","Poronga","ap@gmail.com");
            Student tempStudent3 = new Student("Isra","Poronga","ip@gmail.com");

            //start transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");


        }
        finally {

        }
    }
}

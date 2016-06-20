package com.niklaus.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by NiklausGeisser on 6/19/16.
 */
public class ReadAllStudents {
    public static void main (String[]args){
        // Create session factory
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //Create a session
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            String query = "from Student";

            //query students
            List<Student> theStudents = session.createQuery(query).list();
            System.out.println();
            System.out.println("Displaying all students");
            displayingStudents(theStudents);
            session.getTransaction().commit();
        }
        finally {
            factory.close();

        }

    }

    private static void displayingStudents(List<Student> theStudents) {
        for (Student tempStudent:theStudents
                ) {
            System.out.println(tempStudent);
        }
    }

}

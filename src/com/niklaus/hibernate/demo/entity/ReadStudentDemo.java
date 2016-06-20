package com.niklaus.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by NiklausGeisser on 6/18/16.
 */
public class ReadStudentDemo {
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
            //Get a new session
//            session = factory.getCurrentSession();
//            Student tempStudent = new Student("Claudia","Vaquera","claudiavaqueram@gmail.com");
//            session.beginTransaction();
//            session.save(tempStudent);
//            session.getTransaction().commit();
//
//            //retrieve the student based on the id
//            System.out.println("Getting student with id:"+tempStudent.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = (Student) session.get(Student.class, studentId);
            System.out.println("Get complete: "+myStudent);

            //commit the transaction
            session.getTransaction().commit();



        }
        finally {
            factory.close();

        }
    }
}

package com.niklaus.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by NiklausGeisser on 6/19/16.
 */
public class DeleteStudentDemo {
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

            Student myStudent = (Student) session.get(Student.class, studentId);

            //delete student
            System.out.println("Deleting student: "+myStudent);
            session.delete(myStudent);

            //delete student 2
            session.createQuery("delete from Student s where s.id=2").executeUpdate();


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");


        }
        finally {

        }
    }
}

package com.niklaus.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

/**
 * Created by NiklausGeisser on 6/18/16.
 */
public class QueryStudentDemo {
    public static void main(String[]args){
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
            //display students
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Geisser'").list();
            System.out.println();
            System.out.println("Displaying all students whose lastName is Geisser");
            displayStudents(theStudents);

            System.out.println();
            //Query students : lastName='Poronga' OR firstname="Nik"
            theStudents =
                    session.createQuery("from Student s where " +
                            "s.lastName='Poronga' OR s.firstName='Nik'").list();
            System.out.println("Displaying all the students whoose name is Nik or last name is Poronga");

            displayStudents(theStudents);

            System.out.println();
            //Query students where email LIKE '%luv2code.com'
            System.out.println("Displaying all the students whoose email address ends with gmail.com");
            theStudents =
                    session.createQuery("from Student s where" +
                            " s.email LIKE '%gmail.com'").list();
            displayStudents(theStudents);












            session.getTransaction().commit();


        }
        finally {
            factory.close();

        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent:theStudents
             ) {
            System.out.println(tempStudent);
        }
    }
}

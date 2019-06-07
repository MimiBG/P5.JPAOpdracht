package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) throws SQLException, ParseException {
        try {
            factory = new Configuration().configure().addAnnotatedClass(Reiziger.class)
                    .addAnnotatedClass(OVChipkaart.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();

        //Insert testen
//        Reiziger s = new Reiziger(6, "test", "test");


        // insert into ov only
        Transaction t = session.beginTransaction();
        OVChipkaart ovChipkaart = new OVChipkaart();
        ovChipkaart.setKaartNummer(111);
        ovChipkaart.setSaldo(1000);
        ovChipkaart.setKlasse(2);

//
        Reiziger s = new Reiziger(6, "test", "test");
        ovChipkaart.setReiziger(s);
        s.addToList(ovChipkaart);

        session.save(ovChipkaart);
        t.commit();

        // Voorbeeld READ
//        Transaction t = session.beginTransaction();
//        Reiziger s = session.load(Reiziger.class, 3);
//        System.out.println(s.getFirstname());
//        t.commit();


        // Voorbeeld Insert
//        Transaction t = session.beginTransaction();
//        Reiziger s = new Reiziger(6, "test", "test");
//        session.save(s);
//        t.commit();

        // Voorbeeld met Update
//        Transaction t = session.beginTransaction();
//        Student s = session.load(Student.class, 6);
//        s.setFirstname("Vis");
//        session.save(s);
//        t.commit();

        // Voorbeeld met Delete
//        Transaction t = session.beginTransaction();
//        Student s = session.load(Student.class, 6);
//        session.delete(s);
//        t.commit();



//        Student student1 = new Student(3, "Michele", "Onbekend");
//        Student student2 = new Student(4, "Bart", "Onbekend");


//        session.save(student1);
//        session.save(student2);


//      session.save(listOfStdents);


//      Student x = session.load(Student.class, 1);

//      x.setLastname("Nieuwe achternaam");
//      x.setFirstname("Micheleeee");


//      session.delete(x);

//      session.save(x);


        //Log log = new Log(1,"Hibernate works!");


        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}

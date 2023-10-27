package vn.edu.iuh.fit.ongk1_2.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import vn.edu.iuh.fit.ongk1_2.models.Candidate;
import vn.edu.iuh.fit.ongk1_2.models.Experience;

public class MySessionFactory {
    private static MySessionFactory instance = null;
    private SessionFactory sessionFactory = null;
    private MySessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Candidate.class)
                .addAnnotatedClass(Experience.class)
                .getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    public static MySessionFactory getInstance(){
        if(instance == null){
            instance = new MySessionFactory();
        }
        return instance;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

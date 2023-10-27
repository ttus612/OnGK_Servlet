package vn.edu.iuh.fit.ongk1_2.responsitories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.ongk1_2.factory.MySessionFactory;
import vn.edu.iuh.fit.ongk1_2.models.Candidate;
import vn.edu.iuh.fit.ongk1_2.models.Experience;

public class ExperienceRepository {
    private SessionFactory sessionFactory;

    public ExperienceRepository(){
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }

    public void insert(Experience experience){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = sessionFactory.openSession().beginTransaction();
            sessionFactory.openSession().persist(experience);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }
}

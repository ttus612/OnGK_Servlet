package vn.edu.iuh.fit.ongk1_2.responsitories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.ongk1_2.enums.Roles;
import vn.edu.iuh.fit.ongk1_2.factory.MySessionFactory;
import vn.edu.iuh.fit.ongk1_2.models.Candidate;

import java.util.List;

public class CandidateRepository {
    private SessionFactory sessionFactory;

    public CandidateRepository(){
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }

    public void insert(Candidate candidate){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(candidate);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    public List<Candidate> getAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Candidate> candidates = session.createQuery("from Candidate", Candidate.class).getResultList();
            transaction.commit();
            return candidates;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }

    public Candidate getOne(long id){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Candidate candidate = session.get(Candidate.class, id);
            transaction.commit();
            return candidate;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }

    public List<Candidate> findByRole(Roles role){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Candidate> candidates = session.createNamedQuery("Candidate.findByRole", Candidate.class)
                    .setParameter("role", role).getResultList();

            transaction.commit();
            return candidates;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }

    public List<Candidate> getCandidatesHaveEmail(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Candidate> candidates = session.createNamedQuery("Candidate.haveEmail", Candidate.class)
                    .getResultList();

            transaction.commit();
            return candidates;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }



}

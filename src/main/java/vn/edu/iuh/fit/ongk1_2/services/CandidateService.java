package vn.edu.iuh.fit.ongk1_2.services;

import vn.edu.iuh.fit.ongk1_2.enums.Roles;
import vn.edu.iuh.fit.ongk1_2.models.Candidate;
import vn.edu.iuh.fit.ongk1_2.responsitories.CandidateRepository;

import java.util.List;

public class CandidateService {
    private CandidateRepository candidateRepository;
    public CandidateService(){
        this.candidateRepository = new CandidateRepository();
    }

    public List<Candidate> findAll(){
        return candidateRepository.getAll();
    }

    public Candidate findID(long id){
        return candidateRepository.getOne(id);
    }

    public List<Candidate> findByRole(Roles role){
        return candidateRepository.findByRole(role);
    }
    public List<Candidate> findCandidateHaveEmail(){
        return candidateRepository.getCandidatesHaveEmail();
    }

}

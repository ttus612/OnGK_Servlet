package vn.edu.iuh.fit.ongk1_2.test;

import vn.edu.iuh.fit.ongk1_2.enums.Roles;
import vn.edu.iuh.fit.ongk1_2.models.Candidate;
import vn.edu.iuh.fit.ongk1_2.responsitories.CandidateRepository;

public class Test {
    public static void main(String[] args) {
        CandidateRepository candidateRepository = new CandidateRepository();

        for (Candidate candidate : candidateRepository.getCandidatesByPhoneAndCompany("023333333", "CTY D")) {
            System.out.println(candidate);
        }

//        Candidate candidate = candidateRepository.getOne(1);
//        System.out.println(candidate);


    }
}

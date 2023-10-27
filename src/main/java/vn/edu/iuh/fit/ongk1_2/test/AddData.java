package vn.edu.iuh.fit.ongk1_2.test;

import vn.edu.iuh.fit.ongk1_2.enums.Roles;
import vn.edu.iuh.fit.ongk1_2.models.Candidate;
import vn.edu.iuh.fit.ongk1_2.models.Experience;
import vn.edu.iuh.fit.ongk1_2.responsitories.CandidateRepository;
import vn.edu.iuh.fit.ongk1_2.responsitories.ExperienceRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddData {
    public static void main(String[] args) {
        CandidateRepository candidateReponsitory = new CandidateRepository();

        Candidate candidate = new Candidate("023333333", null, "Nguyen Van A", null);
        Experience experience1 = new Experience(LocalDate.now(), "manager", Roles.MANAGER, "CTY C", LocalDate.now(), candidate);
        Experience experience2 = new Experience(LocalDate.now(), "manager", Roles.MANAGER, "CTY D", LocalDate.now(), candidate);
        List<Experience> experiences = List.of(experience1, experience2);
        candidate.setExperiences(experiences);
        candidateReponsitory.insert(candidate);

        Candidate candidate2 = new Candidate("112375275", "nguyenvanb@gmail", "Nguyen Van B", null);
        Experience experience6 = new Experience(LocalDate.now(), "admin", Roles.ADMINISTRATION, "CTY F", LocalDate.now(), candidate2);
        List<Experience> experiences2 = List.of(experience6);
        candidate2.setExperiences(experiences2);
        candidateReponsitory.insert(candidate2);

        Candidate candidate3 = new Candidate("987654321", "nguyenvanc@gmail", "Nguyen Van C", null);
        Experience experience7 = new Experience(LocalDate.now(), "manager", Roles.MANAGER, "CTY A", LocalDate.now(), candidate3);
        Experience experience8 = new Experience(LocalDate.now(), "staff", Roles.STAFF, "CTY B", LocalDate.now(), candidate3);
        Experience experience9 = new Experience(LocalDate.now(), "admin", Roles.ADMINISTRATION, "CTY C", LocalDate.now(), candidate3);
        List<Experience> experiences3 = List.of(experience7, experience8, experience9);
        candidate3.setExperiences(experiences3);
        candidateReponsitory.insert(candidate3);
    }
}

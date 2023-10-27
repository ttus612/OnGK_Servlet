package vn.edu.iuh.fit.ongk1_2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.ongk1_2.enums.Roles;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "work_desc", length = 120)
    private String workDescription;
    private Roles role;
    @Column(name = "company", length = 120)
    private String companyName;
    @Column(name = "to_date", length = 120)
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Experience() {
    }

    public Experience(LocalDate fromDate, String workDescription, Roles role, String companyName, LocalDate toDate, Candidate candidate) {
        this.fromDate = fromDate;
        this.workDescription = workDescription;
        this.role = role;
        this.companyName = companyName;
        this.toDate = toDate;
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "fromDate=" + fromDate +
                ", id=" + id +
                ", workDescription='" + workDescription + '\'' +
                ", role=" + role +
                ", companyName='" + companyName + '\'' +
                ", toDate=" + toDate +
                ", candidate=" + (candidate != null ? candidate.getId() : null) +
                '}';
    }
}

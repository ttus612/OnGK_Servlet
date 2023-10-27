package vn.edu.iuh.fit.ongk1_2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "candidate")
@NamedQueries({
        @NamedQuery(name = "Candidate.findByRole", query = "from Candidate c join Experience e on c.id = e.candidate.id where e.role = :role"),
        @NamedQuery(name = "Candidate.haveEmail", query = "from Candidate where email is not null")
})
public class Candidate {
    @Column(name = "phone", length = 15)
    private String phone;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "full_name", length = 255)
    private String fullName;
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Experience> experiences;
    @Id
    @Column(name = "can_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Candidate() {
    }

    public Candidate(String phone, String email, String fullName, List<Experience> experiences) {
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.experiences = experiences;
    }

    public Candidate(String phone, String email, String fullName, long id) {
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", experiences=" + experiences +
                ", id=" + id +
                '}';
    }
}

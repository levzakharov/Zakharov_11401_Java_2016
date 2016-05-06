package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@SequenceGenerator(name = "ADMIN_ID_SEQ", sequenceName = "admin_id_seq", allocationSize = 1)
public class Admin {
    private Integer id;
    private Credential credential;
    private String firstName;
    private String lastName;

    public Admin() {
    }

    public Admin(Credential credential, String firstName, String lastName) {
        this.credential = credential;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(generator = "ADMIN_ID_SEQ", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "credential_id")
    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credentialId) {
        this.credential = credentialId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 32)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 32)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", credential=" + credential +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

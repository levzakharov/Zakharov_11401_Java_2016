package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "CLIENT_ID_SEQ", sequenceName = "client_id_seq", allocationSize = 1)
public class Client {
    private Integer id;
    private Credential credential;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private Gender gender;

    public Client() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "CLIENT_ID_SEQ", strategy = GenerationType.SEQUENCE)
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

    public void setCredential(Credential credential) {
        this.credential = credential;
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


    @Column(name = "bdate", nullable = false)
    @Type(type = "date")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Barber{" +
                "id=" + id +
                ", credential=" + credential +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", gender=" + gender +
                '}';
    }
}

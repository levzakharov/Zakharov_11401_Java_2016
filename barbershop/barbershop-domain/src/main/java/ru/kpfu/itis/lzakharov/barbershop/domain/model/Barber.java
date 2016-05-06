package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "barber")
@SequenceGenerator(name = "BARBER_ID_SEQ", sequenceName = "barber_id_seq", allocationSize = 1)
public class Barber {
    private Integer id;
    private Credential credential;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private Gender gender;
    private Barbershop barbershop;

    public Barber() {
    }

    public Barber(Credential credential, String firstName, String lastName, Date birthdate, Gender gender) {
        this.credential = credential;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "BARBER_ID_SEQ", strategy = GenerationType.SEQUENCE)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "barber_barbershop", joinColumns = {@JoinColumn(name = "barber_id")}, inverseJoinColumns = {@JoinColumn(name = "barbershop_id")})
    @JsonIgnore
    public Barbershop getBarbershop() {
        return barbershop;
    }

    public void setBarbershop(Barbershop barbershop) {
        this.barbershop = barbershop;
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

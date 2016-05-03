package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "barber")
@SequenceGenerator(name = "BARBER_ID_SEQ", sequenceName = "barber_id_seq", allocationSize = 1)
public class Barber {
    /**
     * The ID of this barber in database.
     * Value generated from sequence "BARBER_ID_SEQ".
     */
    private int id;

    /**
     * The email of this barber.
     * Should be unique.
     */
    private String email;

    /**
     * The password hash of this barber.
     */
    private String password;

    /**
     * The first name of this barber.
     */
    private String firstName;

    /**
     * The last name of this barber.
     */
    private String lastName;

    /**
     * The birthdate of this barber.
     */
    private Date birthdate;

    /**
     * The gender of this barber.
     *
     * @see Gender
     */
    private Gender gender;

    /**
     * The barbershop where this barber works.
     */
    private Barbershop barbershop;

    public Barber() {
    }

    public Barber(String email, String password, String firstName, String lastName, Date birthdate, Gender gender) {
        this.id = 0;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "BARBER_ID_SEQ", strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, unique = true, length = 32)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", gender=" + gender +
                '}';
    }
}

package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "barbershop")
@SequenceGenerator(name = "BARBERSHOP_ID_SEQ", sequenceName = "barbershop_id_seq", allocationSize = 1)
public class Barbershop {
    /**
     * The ID of this barbershop in database.
     * Value generated from sequence "BARBERSHOP_ID_SEQ".
     */
    private int id;

    /**
     * The address of this barbershop.
     * Should be unique.
     */
    private String address;

    /**
     * The phone number of this barbershop.
     * Should be unique.
     */
    private String phone;

    /**
     * The list of barbers that works in this barbershop.
     */
    private List<Barber> barbers;

    public Barbershop() {
    }

    public Barbershop(String address, String phone) {
        this.id = 0;
        this.address = address;
        this.phone = phone;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "BARBERSHOP_ID_SEQ", strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = false, unique = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = false, unique = true, length = 16)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "barber_barbershop", joinColumns = {@JoinColumn(name = "barbershop_id")}, inverseJoinColumns = {@JoinColumn(name = "barber_id")})
    public List<Barber> getBarbers() {
        return barbers;
    }

    public void setBarbers(List<Barber> barbers) {
        this.barbers = barbers;
    }

    @Override
    public String toString() {
        return "Barbershop{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
@SequenceGenerator(name = "ATTENDANCE_ID_SEQ", sequenceName = "attendance_id_seq", allocationSize = 1)
public class Attendance {
    private Integer id;

    private String name;

    private String price;

    public Attendance() {
    }

    public Attendance(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue(generator = "ATTENDANCE_ID_SEQ", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

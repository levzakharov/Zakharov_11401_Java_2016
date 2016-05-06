package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record")
@SequenceGenerator(name = "RECORD_ID_SEQ", sequenceName = "record_id_seq", allocationSize = 1)
public class Record {
    private Integer id;
    private Client client;
    private Barber barber;
    private Attendance attendance;
    private Date date;
    private Integer hour;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "RECORD_ID_SEQ", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "barber_id")
    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    @ManyToOne
    @JoinColumn(name = "attendance_id")
    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @Column(name = "rdate")
    @Type(type = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "hour")
    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", client=" + client +
                ", barber=" + barber +
                ", attendance=" + attendance +
                ", date=" + date +
                ", hour=" + hour +
                '}';
    }
}

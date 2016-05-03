package ru.kpfu.itis.lzakharov.barbershop.forms;

import org.hibernate.validator.constraints.NotBlank;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Attendance;

import javax.validation.constraints.NotNull;

public class AttendanceForm {
    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @NotNull(message = "Поле не должно быть пустым")
    private String price;

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

    public Attendance toAttendance() {
        return new Attendance(name, price);
    }
}

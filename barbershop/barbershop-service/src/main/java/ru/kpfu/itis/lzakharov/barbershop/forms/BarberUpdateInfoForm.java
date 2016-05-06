package ru.kpfu.itis.lzakharov.barbershop.forms;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Gender;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class BarberUpdateInfoForm {
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 32, message = "Имя должно содержать не более 32 символов")
    private String firstName;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 32, message = "Имя должно содержать не более 32 символов")
    private String lastName;

    @NotNull(message = "Поле не должно быть пустым")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Past
    private Date birthdate;

    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Barber updateBarber(Barber barber) {
        barber.setFirstName(firstName);
        barber.setLastName(lastName);
        barber.setBirthdate(birthdate);
        barber.setGender(gender);

        return barber;
    }
}

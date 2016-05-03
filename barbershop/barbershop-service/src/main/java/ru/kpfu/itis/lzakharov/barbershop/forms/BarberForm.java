package ru.kpfu.itis.lzakharov.barbershop.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Gender;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class BarberForm {
    @NotBlank(message = "Поле не должно быть пустым")
    @Email(message = "email введен некорректно")
    private String email;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 8, max = 32, message = "Пароль должен содержать не менее 8 и не более 32 символов")
    private String password;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 32, message = "Имя должно содержать не более 32 символов")
    private String firstName;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 32, message = "Имя должно содержать не более 32 символов")
    private String lastName;

    @NotNull(message = "Поле не должно быть пустым")
    @DateTimeFormat(pattern = "MM.dd.yyyy")
    @Past
    private Date birthdate;

    private Gender gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public String toString() {
        return "BarberForm{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", gender=" + gender +
                '}';
    }

    public Barber toBarber() {
        return new Barber(email, password, firstName, lastName, birthdate, gender);
    }
}

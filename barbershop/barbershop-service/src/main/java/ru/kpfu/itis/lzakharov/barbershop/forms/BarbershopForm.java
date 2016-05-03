package ru.kpfu.itis.lzakharov.barbershop.forms;

import org.hibernate.validator.constraints.NotBlank;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barbershop;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class BarbershopForm {
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 128, message = "Адрес должен содержать не более 128 символов")
    private String address;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 16, message = "Телефон должен содержать не более 16 символов")
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "BarbershopForm{" +
                "address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Barbershop toBarbershop() {
        return new Barbershop(address, phone);
    }
}

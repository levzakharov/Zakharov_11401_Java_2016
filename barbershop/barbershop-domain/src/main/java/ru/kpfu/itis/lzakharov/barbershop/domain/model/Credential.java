package ru.kpfu.itis.lzakharov.barbershop.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "credential")
@SequenceGenerator(name = "CREDENTIAL_ID_SEQ", sequenceName = "credential_id_seq", allocationSize = 1)
public class Credential {
    private Integer id;
    private String login;
    private String password;
    private Role role;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "CREDENTIAL_ID_SEQ", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, unique = true, length = 32)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

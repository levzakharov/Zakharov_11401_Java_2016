package ru.kpfu.itis.lzakharov.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import ru.kpfu.itis.lzakharov.client.javafx.ViewsLoader;
import ru.kpfu.itis.lzakharov.client.services.LoginService;

import java.io.IOException;

@Configurable
public class LoginController {
    @Autowired
    public ViewsLoader viewsLoader;

    @Autowired
    LoginService loginService;

    @FXML
    Button button;

    @FXML
    TextField login;

    @FXML
    TextField password;

    @FXML
    Label error;

    @FXML
    public void signIn() throws IOException {
        ResponseEntity<Boolean> responseEntity = loginService.signIn(login.getText(), password.getText());
        if (responseEntity.getBody()) {
            viewsLoader.openPage("records");
            System.out.println(login.getCharacters() + " " + password.getCharacters());
        } else {
            error.setVisible(true);
        }
    }
}

package ru.kpfu.itis.lzakharov.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.lzakharov.client.javafx.ViewsLoader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ViewsLoader viewsLoader = context.getBean(ViewsLoader.class);
        viewsLoader.openPage("login");
        primaryStage.setTitle("Login");
        primaryStage.setScene(viewsLoader.getScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

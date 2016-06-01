package ru.kpfu.itis.lzakharov.client.javafx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.io.IOException;
import java.net.URL;

@Configurable
public class ViewsLoader {

    @Autowired
    SpringFXMLLoader loader;

    private Scene scene;

    private String pageRoot = "/views/";

    public ViewsLoader() {
        scene = new Scene(new Pane());
    }

    public void openPage(String pageName) throws IOException {

        URL url = getClass().getResource(pageRoot + pageName + ".fxml");
        Parent root = loader.load(url);
        scene.setRoot(root);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}

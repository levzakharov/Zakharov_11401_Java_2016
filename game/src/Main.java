import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        final Group group = new Group();
        final Scene scene = new Scene(group, 600, 400, Color.GHOSTWHITE);
        stage.setScene(scene);
        stage.setTitle("JavaFX 2 Animations");
        stage.show();
        final Circle circle = new Circle(20, 20, 15);
        circle.setFill(Color.DARKRED);

        final Path path = new Path();
        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new LineTo(500, 10));
        path.setOpacity(0.5);

        group.getChildren().add(path);
        group.getChildren().add(circle);
        final PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.seconds(8.0));
        pathTransition.setDelay(Duration.seconds(.5));
        pathTransition.setPath(path);
        pathTransition.setNode(circle);
//        pathTransition
//                .setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//        pathTransition.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
}

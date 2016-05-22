package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main extends Application {
    private static final int KEYBOARD_MOVEMENT_DELTA = 20;
    private Set<Circle> food = new HashSet<>();
    private final Label scoreLabel = new Label("Score: 0");
    private double speed = 4;
    private final Group group = new Group(scoreLabel);
    private int score = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Circle circle = new Circle(200, 350, 50, Color.BLUEVIOLET);
        circle.setOpacity(0.7);
        group.getChildren().add(circle);


        final Scene scene = new Scene(group, 600, 400, Color.CORNSILK);
        moveCircleOnKeyPress(scene, circle);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), addToFood -> {
            Random random = new Random();
            int x = random.nextInt(600);
            Circle meal = new Circle(x, -25, 25, Color.RED);
            circle.setOpacity(0.7);

            Path path = new Path();
            path.getElements().addAll(new MoveTo(x, 0));
            path.getElements().addAll(new LineTo(x, 325));

            food.add(meal);
            group.getChildren().add(meal);

            final PathTransition pathTransition = new PathTransition();

            pathTransition.setDuration(Duration.seconds(speed));
            pathTransition.setPath(path);
            pathTransition.setNode(meal);
            pathTransition.setOnFinished(event -> {
                if (hasIntersection(circle, meal)) {
                    score += 10;
                } else {
                    score -= 10;
                }

                food.remove(meal);
                group.getChildren().remove(meal);
                scoreLabel.setText("Score: " + score);
            });
            pathTransition.play();

        }));
        timeline.setCycleCount(Animation.INDEFINITE);

        timeline.play();

        stage.setScene(scene);
        stage.show();
    }

    private void moveCircleOnKeyPress(Scene scene, final Circle circle) {
        scene.setOnKeyPressed(event -> {
            double x;
            switch (event.getCode()) {
                case RIGHT:
                    x = circle.getCenterX() + KEYBOARD_MOVEMENT_DELTA;
                    if (x + circle.getRadius() < 625) {
                        circle.setCenterX(circle.getCenterX() + KEYBOARD_MOVEMENT_DELTA);
                    }
                    break;
                case LEFT:
                    x = circle.getCenterX() - KEYBOARD_MOVEMENT_DELTA;
                    if (x - circle.getRadius() > -25) {
                        circle.setCenterX(circle.getCenterX() - KEYBOARD_MOVEMENT_DELTA);
                    }
                    break;
            }
        });
    }

    private boolean hasIntersection(Circle circle, Circle meal) {
        double res = Math.sqrt(Math.pow(circle.getCenterX() - meal.getCenterX(), 2) +
                Math.pow(circle.getCenterY() - meal.getTranslateY(), 2));

        return res < circle.getRadius() + 30;
    }
}
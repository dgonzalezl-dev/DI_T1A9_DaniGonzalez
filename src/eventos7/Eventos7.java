/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos7;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Usuario
 */
public class Eventos7 extends Application {
    Circle circlePane = new Circle(50);
    Circle circle1 = new Circle(100);
    Rectangle rectangulo=new Rectangle(25,100);
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        circlePane.setCenterX(250);
        circlePane.setCenterY(250);
        circlePane.setStroke(Color.BLACK);
        circlePane.setFill(Color.WHITE);
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circlePane);
        pt.setNode(rectangulo);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play(); // Start animation
        circlePane.setOnMousePressed(e -> pt.pause());
        circlePane.setOnMouseReleased(e -> pt.play());

        root.getChildren().add(circlePane);
        root.getChildren().add(rectangulo);
        
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

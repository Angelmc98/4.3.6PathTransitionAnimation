/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathtransitioninanimation;

import javafx.animation.Interpolator;
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
 * @author Angel Medina Cantos
 */
public class PathTransitionInAnimation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Pane sp = new Pane();
         
        primaryStage.setTitle("Path Transition In Animation"); 
        Scene scene = new Scene(sp, 300, 250);
        primaryStage.setScene(scene);
        
        //Creamos el circulo
        Circle circle = new Circle(150, 125, 50, Color.web("black", 0.05));
        circle.setStroke(Color.web("black", 1));
        
        sp.getChildren().add(circle); // Se añade el circulo
        
        //Creamos el rectangulo
        Rectangle rectangulo = new Rectangle(20, 30);
        rectangulo.setFill(Color.CADETBLUE);
        sp.getChildren().add(rectangulo);
        
        
        
        PathTransition path = new PathTransition(Duration.millis(4000), circle, rectangulo);
        path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setCycleCount(Timeline.INDEFINITE);
        
        path.setInterpolator(Interpolator.LINEAR);
        path.play();
        
        sp.setOnMousePressed(event ->{
            
            path.pause();
        });
        
        sp.setOnMouseReleased(event -> {
            
            path.play();
        });
       
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

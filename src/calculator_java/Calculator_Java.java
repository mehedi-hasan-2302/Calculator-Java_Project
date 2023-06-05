
package calculator_java;

//import java.awt.Insets;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 *
 * @author mehedi
 */
public class Calculator_Java extends Application {
    
    private TextField textField = new TextField();
    private long num1=0;
    private String op="";
    private boolean start =true;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        textField.setFont(Font.font(20));
        textField.setPrefHeight(50);
        textField.setAlignment(Pos.CENTER_RIGHT);
        
        StackPane stackpane = new StackPane();
        stackpane.setPadding( new Insets(10,10,10,10));
        stackpane.getChildren().add(textField);
        
        BorderPane root = new BorderPane();
        root.setTop(stackpane);
        Scene scene = new Scene(root,250,300);
        
        
        
     
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

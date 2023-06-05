
package calculator_java;

//import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
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
        textField.setEditable(false);
        
        StackPane stackpane = new StackPane();
        stackpane.setPadding( new Insets(10,10,10,10));
        stackpane.getChildren().add(textField);
        
        
        TilePane tile = new TilePane();
        tile.setHgap(10);
        tile.setVgap(10);
        tile.setAlignment(Pos.TOP_CENTER);
        tile.getChildren().addAll(
        
                    createButtonForNumber("7"),
                    createButtonForNumber("8"),
                    createButtonForNumber("9"),
                    createButtonForNumber("/"),
                    
                    
                    createButtonForNumber("4"),
                    createButtonForNumber("5"),
                    createButtonForNumber("6"),
                    createButtonForNumber("X"),
                    
                    
                    
                    createButtonForNumber("1"),
                    createButtonForNumber("2"),
                    createButtonForNumber("3"),
                    createButtonForNumber("-"),
                    
                    
                    createButtonForNumber("0"),
                    createButtonForNumber("C"),
                    createButtonForNumber("="),
                    createButtonForNumber("+")
          
        );
        
    
        
        BorderPane root = new BorderPane();
        root.setTop(stackpane);
        root.setCenter(tile);
        Scene scene = new Scene(root,250,300);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
             
    }
    
    
    private Button createButtonForNumber(String ch){
        
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50,50);
        button.setOnAction(this::processNumbers);
        return button;
        
    }
    
    
    private Button createButtonForOperator(String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50,50);
        button.setOnAction(this::processOperators);
        return button;
        
        
    }
    
    
    private Button createButtonForClear(String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50,50);
        button.setOnAction(e->{
            textField.setText("");
            op="";
            start=true;
        });
        return button;
        
        
    }
    
    
    private void processNumbers(ActionEvent e){
        if(start){
            textField.setText("");
            start=false;
        }
        
        String value = ((Button)e.getSource()).getText();
        textField.setText(textField.getText()+value);
        
    }
    
    private void processOperators(ActionEvent e){
        String value = ((Button)e.getSource()).getText();
        if(!value.equals("=")){
            if(!op.isEmpty())
                return;
            
            num1 = Long.parseLong(textField.getText());
            op=value;
            textField.setText("");
        
            } 
        
        else{
            if(op.isEmpty()) return;
            long num2 = Long.parseLong(textField.getText());
            calculate(num1,num2,op);
      
        }
   
    }
    
    
    
    private float calculate(long num1, long num2, String operator){
        switch(operator){
            case "+":  return num1+num2;
            case "-":  return num1-num2;
            case "X":  return num1*num2;
            case "/":  
                if(num2==0) return 0;
                return num1/num2;
            default:    return 0;
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

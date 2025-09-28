package numberguesser;
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class NumberGuesser extends Application {
    @Override
    public void start (Stage stage) throws Exception{
var promptLabel= new Label("Guess a number between 1 and 10!");
var inputField = new TextField();
var guessButton=new Button("Guess");
var feedbackLabel= new Label();

var layout= new VBox(10,promptLabel,inputField,guessButton,feedbackLabel);

 var scene= new Scene(layout,300,400);
 stage.setTitle("Number Guessing Game");
 stage.setScene(scene);
stage.show();
    }
    public static void main(String[] args) {
 Application.launch( NumberGuesser.class,args);
    }
}

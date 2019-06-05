package game;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.stage.Modality;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;



public class ConfirmBox {
    static boolean answer;
    
    public static boolean display(String title, String message){
        Stage confirmWindow = new Stage();
        
        //Block Input From Other Window
        confirmWindow.initModality(Modality.APPLICATION_MODAL);
        confirmWindow.setTitle(title);
        
        //Create Label
        Label label1 = new Label(message);
        label1.setTextFill(Paint.valueOf("RED"));
        label1.setFont(Font.font(null, FontWeight.BOLD, 20));
        
        //create two Confirmation button & Set Action
        Button yesBtn = new Button("Yes");
        yesBtn.setTextFill(Paint.valueOf("RED"));
        yesBtn.setFont(Font.font(null, FontWeight.BOLD, 25));
        yesBtn.setOnAction(e ->{
            answer = true;
            confirmWindow.close();
        });
        
        Button noBtn = new Button("No");
        noBtn.setTextFill(Paint.valueOf("RED"));
        noBtn.setFont(Font.font(null, FontWeight.BOLD, 25));
        noBtn.setOnAction(e ->{
            answer = false;
            confirmWindow.close();
        });
        
        //Put the lebel & Button in a Vertical Layout
        VBox layout1= new VBox(10);
        layout1.getChildren().addAll(label1, yesBtn, noBtn);
        layout1.setAlignment(Pos.CENTER);
        
        
        Scene scene = new Scene(layout1, 450, 170);
        //change Scene Theme
        //scene.setFill(Paint.valueOf("DARKGREEN"));
        
        confirmWindow.setScene(scene);
        confirmWindow.showAndWait();
        
        return answer;
    }
}

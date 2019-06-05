package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HowToPlay{
		
		public Button backBtn;
		Scene howToPlayScene;
	
	
public Scene scene(){

        //Create BACK Button & set Action
        backBtn = new Button("<-- BACK ");
        backBtn.setTextFill(Paint.valueOf("RED"));
        backBtn.setFont(Font.font(null, FontWeight.BOLD, 30));
       // backBtn.setOnAction(e ->mainWindow.setScene(selectScene));
        
        //Hoy to play label
        Label howToPlayLabel = new Label("HOW TO PLAY");
        howToPlayLabel.setTextFill(Paint.valueOf("RED"));
        howToPlayLabel.setFont(Font.font(null, FontWeight.BOLD, 30));
        howToPlayLabel.setPadding(new Insets(0, 0, 0, 300));
        //howToPlayLabel.setAlignment(Pos.CENTER);
        
        //Playing instruction label
        Label instructionLabel = new Label("1. Press 'UP' and 'DOWN' arrow key to move the cannon."
                + "\n2. Press 'SPACE Bar' to shoot."
                + "\n3. Destroy 20 Tanks to complete Stage 1." 
                + "\n4. Survive 3 minutes to complete Stage 2." 
                + "\n5. Destroy 5 Ships and 30 jets to save the Border.");
        instructionLabel.setTextFill(Paint.valueOf("RED"));
        instructionLabel.setFont(Font.font(null, FontWeight.BOLD, 25));
        
        //put button & labels in vetical layout
        VBox howToPlayLayout= new VBox(15);
        howToPlayLayout.setPadding(new Insets(10, 50, 50, 30));
        howToPlayLayout.getChildren().addAll(backBtn, howToPlayLabel, instructionLabel);
        
        //settin How To Paly scene
        howToPlayScene = new Scene(howToPlayLayout, 1000, 600);
        //change Scene Theme
        howToPlayScene.setFill(Paint.valueOf("DARKGREEN"));
        //mainWindow.setScene(howToPlayScene);
		
		return howToPlayScene;
    
    }
}
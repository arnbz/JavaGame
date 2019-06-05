package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import  javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class selectstage{

	public Button backBtn;
	public Button level1Btn;
	public Button level2Btn;
	public Button level3Btn;
	Scene selectStageScene;
	

	public Scene scene(){
		backBtn = new Button("<-- BACK ");
		backBtn.setTextFill(Paint.valueOf("RED"));
		backBtn.setFont(Font.font(null, FontWeight.BOLD, 30));
		
		Label selectStageLabel = new Label("Select Stage");
		selectStageLabel.setTextFill(Paint.valueOf("RED"));
		selectStageLabel.setFont(Font.font(null,FontWeight.BOLD,30));
		selectStageLabel.setPadding(new Insets(0,0,0,400));
		
		
		Image image = new Image("stage1.png");
		ImageView lv = new ImageView();
		lv.setImage(image);
		lv.setFitWidth(200);
		lv.setFitHeight(100);
		
		Image image2 = new Image("stage2.png");
		ImageView lv2 = new ImageView();
		lv2.setImage(image2);
		lv2.setFitWidth(200);
		lv2.setFitHeight(100);
		
		Image image3 = new Image("stage3.jpg");
		ImageView lv3 = new ImageView();
		lv3.setImage(image3);
		lv3.setFitWidth(200);
		lv3.setFitHeight(100);
		
		level1Btn = new Button("LEVEL 1");
		level2Btn = new Button("LEVEL 2");
		level3Btn = new Button("LEVEL 3");
		
		HBox buttonLayout = new HBox(320);
		buttonLayout.setPadding(new Insets(70, 0, 0, 30));
		buttonLayout.getChildren().addAll(level1Btn,level2Btn,level3Btn);
		
		HBox imageLayout = new HBox(150);
		imageLayout.setPadding(new Insets(50, 0, 0, 30));
		imageLayout.getChildren().addAll(lv,lv2,lv3);
		
		VBox selectStageLayout= new VBox(50);
		selectStageLayout.getChildren().addAll(backBtn,selectStageLabel,imageLayout,buttonLayout);
		
		Group g = new Group(selectStageLayout);
        
		selectStageScene = new Scene(g,1000,600);
		selectStageScene.setFill(Paint.valueOf("DARKGREEN"));
		
		return selectStageScene;
	}
	
}
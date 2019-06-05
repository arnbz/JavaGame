package game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;

public class table{
	
	Database db = new Database();
	
	//Stage tableViewStage;
	TableView<ScoreList> tableShow;
	
	public Button backBtn;
	
	
	public Scene score(){
		
		 backBtn = new Button("<--BACK");
		backBtn.setTextFill(Paint.valueOf("RED"));
		backBtn.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		
		//name column
		TableColumn<ScoreList,String> NameColumn = new TableColumn<>("name");
		NameColumn.setMinWidth(200);
		NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		
		//age column
		TableColumn<ScoreList,String> AgeColumn = new TableColumn<>("age");
		AgeColumn.setMinWidth(50);
		AgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
		
		//score column
		TableColumn<ScoreList,Integer> ScoreColumn = new TableColumn<>("scores");
		ScoreColumn.setMinWidth(100);
		ScoreColumn.setCellValueFactory(new PropertyValueFactory<>("scores"));
		
		tableShow = new TableView<>();
		tableShow.setItems(db.getscoreList());
		tableShow.getColumns().addAll(NameColumn,AgeColumn,ScoreColumn);
		
		VBox vbox = new VBox(15, backBtn, tableShow);
		
		Scene scoreScene= new Scene(vbox, 1000, 600);
	
		return scoreScene;
	
	}

}
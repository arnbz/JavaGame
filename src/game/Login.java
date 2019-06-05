package game;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;


public class Login {
    //static boolean answer;
    private TextField nameField;
    private TextField ageField;

    private static String name;
    private static String age;


    public String getName() {

        //System.out.println(name);
        return this.name;
    }

    public String getAge() {

        return this.age;
    }

    public void display() {
        Stage loginWindow = new Stage();
        loginWindow.setTitle("Login window");

        //Block Input From Other Window
        loginWindow.initModality(Modality.APPLICATION_MODAL);
        //loginWindow.setTitle(title);

        Button enterButton = new Button("ENTER");
        enterButton.setTextFill(Paint.valueOf("DARKRED"));
        enterButton.setFont(Font.font(null, FontWeight.BOLD, 26));

        nameField = new TextField();
        ageField = new TextField();

        //set placeholder texts in nameField and ageField
        nameField.setPromptText("Enter your name");
        ageField.setPromptText("Enter your age");

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(enterButton, nameField, ageField);
        layout1.setAlignment(Pos.CENTER);
        layout1.setBackground(new Background(new BackgroundFill(Color.valueOf("green"), null, null)));
        //layout1.setPadding(new Insets(10, 0, 0, 500));

        enterButton.setOnAction(e -> {
            name = nameField.getText();
            age = ageField.getText();
            loginWindow.close();
        });


        Scene scene = new Scene(layout1, 500, 500);

        scene.setFill(Paint.valueOf("DARKGREEN"));

        loginWindow.setScene(scene);
        loginWindow.showAndWait();

    }
}

package game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartScreen extends Application {

    Stage mainWindow;
    Scene selectScene, selectStageScene, howToPlayScene, scoreScene, popUp, loginScene;
    Group root;
    Login login = new Login();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        Stage popUpStage = new Stage();

        //Create all buttons & set their action
        Button startGameBtn = new Button();
        startGameBtn.setText(" START GAME ");
        startGameBtn.setTextFill(Paint.valueOf("DARKGREEN"));
        startGameBtn.setFont(Font.font(null, FontWeight.BOLD, 26));
        startGameBtn.setOnAction(e -> {
            login();
            mainWindow.setScene(Stage1.stage_1(mainWindow));
        });

        //select stage button
        Button selectStageBtn = new Button();
        selectStageBtn.setText("SELECT STAGE");
        selectStageBtn.setTextFill(Paint.valueOf("DARKGREEN"));
        selectStageBtn.setFont(Font.font(null, FontWeight.BOLD, 26));
        selectStageBtn.setOnAction(e -> selectStage());

        //score button
        Button highScoreBtn = new Button();
        highScoreBtn.setText("SCORE LIST ");
        highScoreBtn.setTextFill(Paint.valueOf("DARKGREEN"));
        highScoreBtn.setFont(Font.font(null, FontWeight.BOLD, 30));
        highScoreBtn.setOnAction(e -> scoreList());

        //How to play button
        Button howToPlayBtn = new Button();
        howToPlayBtn.setText("HOW TO PLAY");
        howToPlayBtn.setTextFill(Paint.valueOf("DARKGREEN"));
        howToPlayBtn.setFont(Font.font(null, FontWeight.BOLD, 26));
        howToPlayBtn.setOnAction(e -> howtoPlay());

        //quit button
        Button quitBtn = new Button();
        quitBtn.setText("-----QUIT------");
        quitBtn.setTextFill(Paint.valueOf("DARKGREEN"));
        quitBtn.setFont(Font.font(null, FontWeight.BOLD, 22));
        quitBtn.setOnAction(e -> closeProgram());

        //Put all buttons in a Vertical Layout
        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(startGameBtn, selectStageBtn, highScoreBtn, howToPlayBtn, quitBtn);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(270, 0, 0, 735));


        //set image to scene
        Image image = new Image("startScene.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(600);

        root = new Group();
        root.getChildren().addAll(imageView, layout1);

        selectScene = new Scene(root, 1000, 600);


        mainWindow.setTitle("SELECT WINDOW");
        mainWindow.setScene(selectScene);
        mainWindow.show();
    }

    private void login() {

        //prompts name and age
        login.display();
    }

    private void closeProgram() {
        //call static display method from confirmbox
        Boolean answer = ConfirmBox.display("QUIT WINDOW", "Do you want to escape from the BATTLE??");

        if (answer)
            mainWindow.close();
    }

    //showing a tableview by calling ScoreList class
    private void scoreList() {

        table t = new table();
        scoreScene = t.score();
        mainWindow.setScene(scoreScene);

        t.backBtn.setOnAction(e -> mainWindow.setScene(selectScene));

    }

    //showing an instruction by calling HowToPlay class
    private void howtoPlay() {

        HowToPlay h = new HowToPlay();
        howToPlayScene = h.scene();
        mainWindow.setScene(howToPlayScene);

        h.backBtn.setOnAction(e -> mainWindow.setScene(selectScene));

    }

    //showing selected stage
    private void selectStage() {
        selectstage s = new selectstage();
        selectStageScene = s.scene();
        mainWindow.setScene(selectStageScene);

        s.backBtn.setOnAction(e -> mainWindow.setScene(selectScene));
        s.level1Btn.setOnAction(e -> mainWindow.setScene(Stage1.stage_1(mainWindow)));
        s.level2Btn.setOnAction(e -> mainWindow.setScene(stage2.stage_2()));
        s.level3Btn.setOnAction(e -> mainWindow.setScene(stage3.stage_3()));
    }


}

package game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sun.awt.windows.ThemeReader;


public class Tank implements Runnable {

    private Stage primaryWindow;

    Group tankGroup = new Group();

    static int score = 0;
    Label scoreLabel = new Label("Score: " + score);

    Rectangle tank1 = new Rectangle(2620, 405, 100, 50);
    Rectangle tank2 = new Rectangle(2620, 405, 100, 50);
    Rectangle tank3 = new Rectangle(2620, 405, 100, 50);
    Rectangle tank4 = new Rectangle(2620, 405, 100, 50);
    Rectangle tank5 = new Rectangle(2620, 405, 100, 50);

    public Tank(Stage primaryWindow) {
        this.primaryWindow = primaryWindow;
    }

    public void insertInfo() {
        Database db = new Database();
        Login login = new Login();
        String name = login.getName();
        String age = login.getAge();
        db.insert(score, name, age);
        //System.out.println(a);
        //db.insert("a","b",0);
    }


    public Group tankCollection() {
        Button beginBtn = new Button("BEGIN!!");
        beginBtn.setPadding(new Insets(20, 0, 0, 0));
        beginBtn.setOnAction(e -> {

            //addTankList();

            Thread t = new Thread(this);
            t.start();
        });

        tankGroup.getChildren().addAll(beginBtn, tank1, tank2, tank3, tank4, tank5, scoreLabel);
        return tankGroup;

    }

    public void run() {

        Image tank = new Image("tank.png");
        Image tankBlack = new Image("tankBlack.png");
		
		/*int i=random.rndFun();
		int j=random.rndFun();
		int k=random.rndFun();
		int l=random.rndFun();
		int m=random.rndFun();*/

        tank1.setX(TankPosition.getRandomPosition());
        tank2.setX(TankPosition.getRandomPosition());
        tank3.setX(TankPosition.getRandomPosition());
        tank4.setX(TankPosition.getRandomPosition());
        tank5.setX(TankPosition.getRandomPosition());

        tank1.setFill(new ImagePattern(tank));
        tank2.setFill(new ImagePattern(tank));
        tank3.setFill(new ImagePattern(tankBlack));
        tank4.setFill(new ImagePattern(tankBlack));
        tank5.setFill(new ImagePattern(tank));


        while (true) {

            if (score >= 200) {
                insertInfo();

                //show game won window

                Platform.runLater(()->{
                    Label winLabel = new Label("You won!");
                    winLabel.setTextFill(Paint.valueOf("DARKGREEN"));
                    winLabel.setFont(Font.font(null, FontWeight.BOLD, 26));

                    HBox hBox = new HBox();
                    hBox.getChildren().add(winLabel);
                    hBox.setAlignment(Pos.CENTER);

                    VBox vBox = new VBox();
                    vBox.getChildren().add(hBox);
                    vBox.setAlignment(Pos.CENTER);

                    Scene gameWonScene = new Scene(vBox, 1000, 600);
                    primaryWindow.setScene(gameWonScene);

                    primaryWindow.show();
                });

                break;

            } else if (tank1.getX() == 100 || tank2.getX() == 100 || tank3.getX() == 100 || tank4.getX() == 100 || tank5.getX() == 100) {
                insertInfo();

                //show game lost window

                Platform.runLater(()->{
                    Label lostLabel = new Label("You lost!");
                    lostLabel.setTextFill(Paint.valueOf("DARKGREEN"));
                    lostLabel.setFont(Font.font(null, FontWeight.BOLD, 26));

                    HBox hBox = new HBox();
                    hBox.getChildren().add(lostLabel);
                    hBox.setAlignment(Pos.CENTER);

                    VBox vBox = new VBox();
                    vBox.getChildren().add(hBox);
                    vBox.setAlignment(Pos.CENTER);

                    Scene gameLostScene = new Scene(vBox, 1000, 600);
                    primaryWindow.setScene(gameLostScene);

                    primaryWindow.show();
                });

                break;
            }

            double cx = tank1.getX();

            Platform.runLater(() -> tank1.setX(cx - 5));

            if (tank1.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    tank1.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + score);
                });
            }

            double cx2 = tank2.getX();
            Platform.runLater(() -> tank2.setX(cx2 - 5));

            if (tank2.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched2");

                score += 10;
                Platform.runLater(() -> {
                    tank2.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + score);
                });
            }

            double cx3 = tank3.getX();
            Platform.runLater(() -> tank3.setX(cx3 - 5));

            if (tank3.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched3");

                score += 10;
                Platform.runLater(() -> {
                    tank3.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + score);
                });
            }

            double cx4 = tank4.getX();
            Platform.runLater(() -> tank4.setX(cx4 - 5));

            if (tank4.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched4");

                score += 10;
                Platform.runLater(() -> {
                    tank4.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + score);
                });

            }

            double cx5 = tank5.getX();
            Platform.runLater(() -> tank5.setX(cx4 - 5));

            if (tank5.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched5");

                score += 10;
                Platform.runLater(() -> {
                    tank5.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + score);
                });
            }


            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
        }

        //insertInfo();

    }


}
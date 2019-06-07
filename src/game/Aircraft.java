package game;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.control.Button;

import javafx.application.Platform;
import javafx.scene.control.Label;


public class Aircraft implements Runnable {

    Group tankGroup = new Group();

    static int score = 0;
    Label scoreLabel = new Label("Score: " + String.valueOf(score));

    //creating rectangle type aircraft object
    Rectangle aircraft1 = new Rectangle(2620, 105, 100, 50);
    Rectangle aircraft2 = new Rectangle(2620, 205, 100, 50);
    Rectangle aircraft3 = new Rectangle(2620, 105, 100, 50);
    Rectangle aircraft4 = new Rectangle(2620, 205, 100, 50);
    Rectangle aircraft5 = new Rectangle(2620, 105, 100, 50);

    public void insertInfo() {
        Database db = new Database();
        Login lg = new Login();

        db.insert(0, lg.getName(), lg.getAge());
    }

    public Group aircraftCollection() {
        Button beginBtn = new Button("BEGIN!!");
        beginBtn.setOnAction(e -> {


                    Thread t = new Thread(this);
                    t.start();

                }

        );

        tankGroup.getChildren().addAll(beginBtn, aircraft1, aircraft2, aircraft3, aircraft4, aircraft5, scoreLabel);
        return tankGroup;

    }

    public void run() {


        Image aircraft = new Image("fighter.png");


        //set x-axis of aircraft
        aircraft1.setX(TankPosition.getRandomPosition());
        aircraft2.setX(TankPosition.getRandomPosition());
        aircraft3.setX(TankPosition.getRandomPosition());
        aircraft4.setX(TankPosition.getRandomPosition());
        aircraft5.setX(TankPosition.getRandomPosition());

        //Fill Image for aircraft
        aircraft1.setFill(new ImagePattern(aircraft));
        aircraft2.setFill(new ImagePattern(aircraft));
        aircraft3.setFill(new ImagePattern(aircraft));
        aircraft4.setFill(new ImagePattern(aircraft));
        aircraft5.setFill(new ImagePattern(aircraft));


        while (score != 400 && aircraft1.getX() != 100 && aircraft2.getX() != 100 && aircraft3.getX() != 100 && aircraft4.getX() != 100 && aircraft5.getX() != 100) {

            double cx = aircraft1.getX();
            Platform.runLater(()->aircraft1.setX(cx - 5));

            if (aircraft1.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    aircraft1.setX(TankPosition.getRandomPosition());
                    CannonBall.cBall.setCenterX(2000);
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }

            double cx2 = aircraft2.getX();
            Platform.runLater(()->aircraft2.setX(cx2 - 5));

            if (aircraft2.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    aircraft2.setX(TankPosition.getRandomPosition());
                    CannonBall.cBall.setCenterX(2000);
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }

            double cx3 = aircraft3.getX();
            Platform.runLater(()->aircraft3.setX(cx3 - 5));

            if (aircraft3.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    aircraft3.setX(TankPosition.getRandomPosition());
                    CannonBall.cBall.setCenterX(2000);
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }

            double cx4 = aircraft4.getX();
            Platform.runLater(()->aircraft4.setX(cx4 - 5));

            if (aircraft4.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    aircraft4.setX(TankPosition.getRandomPosition());
                    CannonBall.cBall.setCenterX(2000);
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }

            double cx5 = aircraft5.getX();
            Platform.runLater(()->aircraft5.setX(cx5 - 5));

            if (aircraft5.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    aircraft5.setX(TankPosition.getRandomPosition());
                    CannonBall.cBall.setCenterX(2000);
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }


            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
        }
        insertInfo();
    }


}
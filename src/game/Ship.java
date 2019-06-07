package game;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.control.Button;

import javafx.application.Platform;
import javafx.scene.control.Label;


public class Ship implements Runnable {

    //ArrayList <Rectangle> tankList = new ArrayList <Rectangle> ();
    Group shipGroup = new Group();

    static int score = 0;
    Label scoreLabel = new Label("Score: " + String.valueOf(score));

    //ship object
    Rectangle ship1 = new Rectangle(2620, 405, 100, 50);
    Rectangle ship2 = new Rectangle(2620, 405, 100, 50);
    Rectangle ship3 = new Rectangle(2620, 405, 100, 50);
    Rectangle ship4 = new Rectangle(2620, 405, 100, 50);
    Rectangle ship5 = new Rectangle(2620, 405, 100, 50);

    public void insertInfo(int score, String name, String age) {
        Database db = new Database();
        db.insert(score, name, age);
    }


    //return a group of ship objects
    public Group shipCollection() {
        Button beginBtn = new Button("BEGIN!!");
        beginBtn.setOnAction(e -> {

            Thread t = new Thread(this);
            t.start();

        });

        shipGroup.getChildren().addAll(beginBtn, ship1, ship2, ship3, ship4, ship5, scoreLabel);
        return shipGroup;
    }

    public void run() {

        Image shipImage = new Image("ship.png");
        //Image tankBlack = new Image("tankBlack.png");

        //setting X-axis of ship with random values
        ship1.setX(TankPosition.getRandomPosition());
        ship2.setX(TankPosition.getRandomPosition());
        ship3.setX(TankPosition.getRandomPosition());
        ship4.setX(TankPosition.getRandomPosition());
        ship5.setX(TankPosition.getRandomPosition());


        //Fill Image for ships
        ship1.setFill(new ImagePattern(shipImage));
        ship2.setFill(new ImagePattern(shipImage));
        ship3.setFill(new ImagePattern(shipImage));
        ship4.setFill(new ImagePattern(shipImage));
        ship5.setFill(new ImagePattern(shipImage));


        //decreasing the position with time
        while (score != 200 && ship1.getX() != 100 && ship2.getX() != 100
                && ship3.getX() != 100 && ship4.getX() != 100 && ship5.getX() != 100) {

            double cx = ship1.getX();
            Platform.runLater(()->ship1.setX(cx - 5));

            if (ship1.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    ship1.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }

            double cx2 = ship2.getX();
            Platform.runLater(()->ship2.setX(cx2 - 5));

            if (ship2.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    ship2.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }

            double cx3 = ship3.getX();
            Platform.runLater(()->ship3.setX(cx3 - 5));

            if (ship3.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    ship3.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }


            double c4 = ship4.getX();
            Platform.runLater(()->ship4.setX(cx3 - 5));

            if (ship4.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    ship4.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }

            double cx5 = ship5.getX();
            Platform.runLater(()->ship5.setX(cx3 - 5));

            if (ship5.intersects(CannonBall.cBall.getBoundsInLocal())) {
                System.out.println("touched1");

                score += 10;
                Platform.runLater(() -> {
                    ship5.setX(TankPosition.getRandomPosition());
                    scoreLabel.setText("Score: " + String.valueOf(score));
                });
            }


            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
        }

        //insertInfo(score);
    }


}
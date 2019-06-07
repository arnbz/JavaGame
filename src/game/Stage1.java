package game;

import game.Cannon;
import game.CannonBall;
import game.Projectile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;

public class Stage1 {
    static Thread th;
    static double angle = 0;
    static int v = 0;
    static Button shootBtn;

    public static Scene stage_1() {

        CannonBall cannonBall = new CannonBall(80, 417);
        Group root = new Group();
        HBox layout1 = new HBox();
        Scene stage1Scene = new Scene(root, 1000, 600);

        Image image = new Image("stage1.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(600);

        Tank tank = new Tank();
        Cannon cannon = new Cannon();

        shootBtn = new Button("Shoot!!");
        shootBtn.setTextFill(Paint.valueOf("RED"));
        shootBtn.setFont(Font.font(null, FontWeight.BOLD, 30));
        shootBtn.setOnAction(e -> {

            Projectile.xList.clear();
            Projectile.yList.clear();
            th = new Thread(cannonBall);
            th.start();

        });
        shootBtn.setVisible(true);

        layout1.getChildren().add(shootBtn);
        layout1.setPadding(new Insets(0, 0, 0, 450));


        root.getChildren().addAll(imageView, tank.tankCollection(), cannon.cannonImage(50, 415, 45, 397), layout1, cannonBall);

        stage1Scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {

            if (e.getCode() == KeyCode.UP) {
                if (angle > -90)
                    angle -= 5;
                cannon.ivGun.setRotate(angle);
            } else if (e.getCode() == KeyCode.DOWN) {
                if (angle < 0)
                    angle += 5;
                cannon.ivGun.setRotate(angle);
            }

        });

        return stage1Scene;

    }
}


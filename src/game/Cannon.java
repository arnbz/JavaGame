package game;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Cannon {

    private Group cannonRoot = new Group();
    ImageView ivBase, ivGun;

    public Group cannonImage(int canonBaseX, int canonBaseY, int cannonGunX, int cannonGunY) {


        Image canonBase = new Image("canonbase.png");
        ivBase = new ImageView();
        ivBase.setImage(canonBase);
        ivBase.setFitWidth(50);
        ivBase.setFitHeight(50);
        ivBase.setX(canonBaseX);
        ivBase.setY(canonBaseY);

        Image cannongun = new Image("canongun.png");
        ivGun = new ImageView();
        ivGun.setImage(cannongun);
        ivGun.setFitWidth(70);
        ivGun.setFitHeight(30);
        ivGun.setX(cannonGunX);
        ivGun.setY(cannonGunY);

        cannonRoot.getChildren().addAll(ivBase, ivGun);

        return cannonRoot;
    }
}
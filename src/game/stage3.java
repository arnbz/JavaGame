package game;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;

public class stage3 {
	static Thread th;
	static int v=0;
	static Button shootBtn;
	public static Scene stage_3(){
		
		CannonBall cB = new CannonBall(80,457);
		Group root = new Group();
		HBox layout1 = new HBox();
		Scene stage3Scene = new Scene(root,1000,600);
		
		Image image = new Image("stage3.jpg");
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setFitWidth(1000);
		iv.setFitHeight(600);
		
		//Aircraft a = new Aircraft();
		Ship sp = new Ship();
		Cannon c = new Cannon();
		
		shootBtn = new Button("Shoot!!");
		shootBtn.setTextFill(Paint.valueOf("RED"));
		shootBtn.setFont(Font.font(null, FontWeight.BOLD, 30));
		shootBtn.setOnAction(e->{

			Projectile.xList.clear();
			Projectile.yList.clear();
			th = new Thread(cB);			
			th.start();
			
		}
			
		);
		shootBtn.setVisible(true);
		
		layout1.getChildren().add(shootBtn);
		layout1.setPadding(new Insets(0, 0, 0, 450));

		
		
		root.getChildren().addAll(iv,sp.shipCollection(), c.cannonImage(50, 455, 45, 437), layout1 ,cB);
		
		stage3Scene.addEventFilter(KeyEvent.KEY_PRESSED,	e->{
			
			if(e.getCode()== KeyCode.UP){
				if(Stage1.angle > -90 )
					Stage1.angle -= 15;
				c.ivGun.setRotate(Stage1.angle);
			}	
				
			else if(e.getCode()== KeyCode.DOWN){
				if(Stage1.angle < 0 )
					Stage1.angle += 15;
				c.ivGun.setRotate(Stage1.angle);
			}
			
			
	});
		
		return stage3Scene;
		
	}
}


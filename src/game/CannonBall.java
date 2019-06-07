package game;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.shape.*;

import java.util.*;

public class CannonBall extends Group implements Runnable{

	private double centrX, centrY;

	public static Circle cBall;

	public CannonBall(double x, double y){
		
		cBall = new Circle(x,y,10);

		//todo: check why extending group and see workarounds
		super.getChildren().add(cBall);
		centrX = x;
		centrY = y;
	}
	
	public void run(){

		Projectile.projectileCoordinate(centrX, centrY);
		ArrayList<Double> xList = Projectile.xList;
		ArrayList<Double> yList = Projectile.yList;
		
		Iterator<Double> xListIte = xList.iterator();
		Iterator<Double> yListIte = yList.iterator();
		
		while(xListIte.hasNext())
		{
			double xCoordinate = xListIte.next();
			double yCoordinate = centrY - yListIte.next();
			
			Platform.runLater(() -> cBall.setCenterX(xCoordinate));
			Platform.runLater(() -> cBall.setCenterY(yCoordinate));
			
			try{Thread.sleep(10);}
			catch(Exception ex){}
		}
		
		//stage1 s= new stage1();
		//s.shootBtn.setVisible(true);
		Projectile.xList.clear();
		Projectile.yList.clear();

		Platform.runLater(()->cBall.setCenterX(80));
		Platform.runLater(()->cBall.setCenterY(417));
		
	}
	
	
	
	
}
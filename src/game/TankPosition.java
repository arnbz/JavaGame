package game;

import java.util.Random;

public class TankPosition {
	
	public static int getRandomPosition(){
		int[] a = new int[]{1020,1130,1240,1350,1460,1570,1680,1770,1880};
		 
		java.util.Random rnd = new java.util.Random();
		return (a[rnd.nextInt(a.length)]);
	}
	
}
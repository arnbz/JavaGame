package game;

// This program computes the trajectory of a projectile.

import java.util.ArrayList;

public class Projectile {
    // constant for Earth acceleration in meters/second^2

    //note: component of acceleration along the x-axis is 0
    //Ay is component of acceleration along the y-axis
    final static double Ay = -9.81;

    public static ArrayList<Double> xList = new ArrayList<>();
    public static ArrayList<Double> yList = new ArrayList<>();

    public static void projectileCoordinate(double startX, double startY) {

        int steps = 100;
        //System.out.println(Stage1.angle);

        /*angle value ranges from 0 to -90
          angle increments occur by -15 and +15
          except 0, angle value is always negative; thus we multiply with -1
          to make it positive*/
        double theta = -1 * Stage1.angle;

        //System.out.println(a);

        //todo: figure out why calculating in radians
        double angle = Math.toRadians(theta);

        //We assume the initial velocity Vo is 100
        double Vo = 100;

        //x component of initial velocity
        double Vox = Vo * Math.cos(angle);

        //y component of initial velocity
        double Voy = Vo * Math.sin(angle);

        /*as Ay is negative and time of flight cannot be negative, we multiply with -2
          to make the result positive.*/
        double timeOfFlight = -2.0 * Voy / Ay;
        double timeIncrement = timeOfFlight / steps;
        double xIncrement = Vox * timeIncrement;

        double xDistance = startX;
        double yDistance = startY;
        double t = 0.0;

        for (int i = 1; i <= steps; i++) {
            t += timeIncrement;

            xDistance += xIncrement;
            xList.add(round2(xDistance));

            yDistance = Voy * t + 0.5 * Ay * t * t;
            yList.add(round2(yDistance));

        }
    }

    public static double round2(double n) {
        return (int) (n * 100.0 + 0.5) / 100.0;
    }
}

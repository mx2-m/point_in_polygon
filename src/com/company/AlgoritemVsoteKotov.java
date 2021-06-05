package com.company;

import java.util.ArrayList;

import static java.lang.Double.NaN;

public class AlgoritemVsoteKotov {

    ArrayList<Point> solution = new ArrayList<>();


    /*public static float angleBetween2Lines(Point A1, Point A2, Point B1, Point B2) {
        float angle1 = (float) Math.atan2(A2.y - A1.y, A1.x - A2.x);
        float angle2 = (float) Math.atan2(B2.y - B1.y, B1.x - B2.x);
        float calculatedAngle = (float) Math.toDegrees(angle2 - angle1);
        if (calculatedAngle < -180) calculatedAngle += 360;
        else if (calculatedAngle > 180) calculatedAngle -= 360;

        return calculatedAngle;
    }*/

    public ArrayList<Point> algoritemVsoteKotov(ArrayList<Point> mnogokotnik, ArrayList<Point> points) {

        double sum = 0;
        double angle = 0;
        double angleFirstLast = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 1; j < mnogokotnik.size(); j++) {
                Vector2D v1 = new Vector2D(mnogokotnik.get(j - 1).x - points.get(i).x, mnogokotnik.get(j - 1).y - points.get(i).y);
                Vector2D v2 = new Vector2D(mnogokotnik.get(j).x - points.get(i).x, mnogokotnik.get(j).y - points.get(i).y);

          /*     angle =angleBetween2Lines(new Point(points.get(i).x,points.get(i).y),new Point(mnogokotnik.get(j - 1).x,mnogokotnik.get(j - 1).y),new Point(points.get(i).x,points.get(i).y),new Point(mnogokotnik.get(j).x,mnogokotnik.get(j).y));
                System.out.println("Angle " + angle);

                if (j == mnogokotnik.size() - 1) {

                    angleFirstLast = angleBetween2Lines(new Point(points.get(i).x, points.get(i).y), new Point(mnogokotnik.get(0).x, mnogokotnik.get(0).y), new Point(points.get(i).x, points.get(i).y), new Point(mnogokotnik.get(mnogokotnik.size() - 1).x, mnogokotnik.get(mnogokotnik.size() - 1).y));
                    System.out.println("AL " + angleFirstLast);
                }
                sum = sum + angle + angleFirstLast;
                System.out.println("Summ " + sum);*/


               angle = v1.angle(v2.normalize());
                System.out.println("Angle " + angle);

                if (j == mnogokotnik.size() - 1) {
                    Vector2D v3 = new Vector2D(mnogokotnik.get(0).x - points.get(i).x, mnogokotnik.get(0).y - points.get(i).y);
                    Vector2D v4 = new Vector2D(mnogokotnik.get(mnogokotnik.size() - 1).x - points.get(i).x, mnogokotnik.get(mnogokotnik.size() - 1).y - points.get(i).y);

                    angleFirstLast = v3.angle(v4.normalize());
                    System.out.println("FL " + angleFirstLast);
                }
                //sum = sum +v2.angle(v1.normalize());
                sum = sum + angle + angleFirstLast;


            }
            System.out.println("suma uglova" + sum);
            if (sum > 350) {
                solution.add(new Point(points.get(i).x, points.get(i).y));
            }
            sum = 0;
            angle = 0;
            angleFirstLast = 0;

        }


        System.out.println("suma uglova" + sum);
        return solution;
    }



}

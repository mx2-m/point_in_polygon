package com.company;

import java.util.ArrayList;

public class AlgoritemEnakihPredznakov {


    ArrayList<Point> solution = new ArrayList<>();

    public int orientation(Point p0, Point p1, Point p2) {
        double cp1 = (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
        if (cp1 > 0)   //lijevo
            return 1;
        else if (cp1 == 0)
            return 0;
        else
            return -1;
    }

    public ArrayList<Point> algoritemEnakihPredznakov(ArrayList<Point> mnogokotnik, ArrayList<Point> points) {

        int orientation1 = 0;
        int orientationEnd = 0;
        int sum = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 1; j < mnogokotnik.size(); j++) {
                orientation1 = orientation(points.get(i), mnogokotnik.get(j - 1), mnogokotnik.get(j));
                System.out.println("Orientation" + orientation1);

                if (j == mnogokotnik.size() - 1) {
                    orientationEnd = orientation(points.get(i), mnogokotnik.get(mnogokotnik.size() - 1), mnogokotnik.get(0));
                    System.out.println("OrientationE" + orientationEnd);
                }

                sum = sum + orientation1 + orientationEnd;

            }
            if (sum == mnogokotnik.size() || sum == -mnogokotnik.size()) {
                solution.add(new Point(points.get(i).x, points.get(i).y));
            }
            sum = 0;
            orientation1 = 0;
            orientationEnd = 0;
        }


        return solution;
    }


}

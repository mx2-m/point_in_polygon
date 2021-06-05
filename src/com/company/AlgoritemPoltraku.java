package com.company;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AlgoritemPoltraku {

    ArrayList<Point> solution = new ArrayList<>();


    public ArrayList<Point> algoritamPoltraku(ArrayList<Point> mnogokotnik, ArrayList<Point> points) {

        int endPoint = mnogokotnik.size() - 1;
        int odd = 0;

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < mnogokotnik.size(); j++) {

                if ((mnogokotnik.get(j).y > points.get(i).y) != (mnogokotnik.get(endPoint).y > points.get(i).y)
                        && points.get(i).x < (mnogokotnik.get(endPoint).x - mnogokotnik.get(j).x) * (points.get(i).y - mnogokotnik.get(j).y) / (mnogokotnik.get(endPoint).y - mnogokotnik.get(j).y) + mnogokotnik.get(j).x) {
                    odd++;
                }

                endPoint = j;
            }
            if (odd % 2 != 0) {
                solution.add(new Point(points.get(i).x, points.get(i).y));
            }
            odd = 0;


        }

        System.out.println("Size" + solution.size());
        return solution;
    }


    public static void main(String[] a) {
        int[][] testPoints = {{30, 30}};

    }

    final static int[][] square = {{0, 0}, {20, 0}, {20, 20}, {0, 20}};
    final static int[][][] shapes = {square};
}



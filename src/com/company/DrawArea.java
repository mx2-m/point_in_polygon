package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class DrawArea extends JComponent {

    private Image image;         // Image in which we're going to draw
    private Graphics2D g2;     // Graphics2D object ==> used to draw on
    ArrayList<Point> points = new ArrayList<>();

    public DrawArea() {
        setDoubleBuffered(false);
    }


    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void red() {
        g2.setPaint(Color.red);
    }

    public void green() {
        g2.setPaint(Color.green);
    }


    public void drawingTocki(double x1, double y1) {

        g2.fillRect((int) x1, (int) y1, 5, 5);
        g2.drawString("T1", (int) x1, (int) y1);

        repaint();
    }


   /* public void drawingPointsNormaly(int number) {
        double x ,y;
        for(int i=0;i<number;i++){
            double len = Math.sqrt(Math.random())*250; //200 je radius
            double deg = Math.random() * 2 * Math.PI;
             x = 300 + len * Math.cos(deg); //prvi broj je centar
             y = 300 + len * Math.sin(deg);

            g2.fillRect((int) x, (int) y, 5, 5);
        }


        repaint();
    }*/

    public void drawingPointsNormaly(int number) {
        double x, y;
        points.clear();
        Random r1 = new Random();
        for (int i = 0; i < number; i++) {
            x = 50 * r1.nextGaussian() + 300;
            y = 50 * r1.nextGaussian() + 300;

            g2.fillRect((int) x, (int) y, 5, 5);
            points.add(new Point(x, y));
        }

        repaint();
    }

    public void drawingPointsEvenly(int number) {
        double x, y;
        points.clear();
        Random r1 = new Random();
        for (int i = 0; i < number; i++) {
            x = 500 * r1.nextDouble() + 50;
            y = 500 * r1.nextDouble() + 50;

            g2.fillRect((int) x, (int) y, 5, 5);
            points.add(new Point(x, y));
        }

        repaint();
    }

    public void drawingDaljice(ArrayList<Point> points) {
        g2.setPaint(Color.red);

        for (int i = 1; i < points.size(); i++) {
            g2.drawLine((int) points.get(i - 1).x, (int) points.get(i - 1).y, (int) points.get(i).x, (int) points.get(i).y);
        }
        g2.drawLine((int) points.get(0).x, (int) points.get(0).y, (int) points.get(points.size() - 1).x, (int) points.get(points.size() - 1).y);
        repaint();
    }

    public void drawingPoints(ArrayList<Point> points) {
        g2.setPaint(Color.red);

        for (int i = 1; i < points.size(); i++) {
            g2.fillRect((int) points.get(i - 1).x, (int) points.get(i - 1).y, 5, 5);
            repaint();
        }
    }

    public void drawSolution(ArrayList<Point> points) {

        g2.setPaint(Color.green);

        for (int i = 0; i < points.size(); i++) {
            g2.fillRect((int) points.get(i).x, (int) points.get(i).y, 5, 5);

            repaint();
        }

    }

    public void drawingDaljica(double x1, double y1, double x2, double y2) {
        g2.setPaint(Color.red);

        g2.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        repaint();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
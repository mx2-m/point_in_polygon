package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private JLabel algorithm;
    private JLabel placementOfPoints;
    private JLabel numberOfPoints;
    private JPanel panelMain;
    //algoritmi
    private JRadioButton poltrak;
    private JRadioButton vsotaKotov;
    private JRadioButton enakiPredznaki;
    //raspored tocki
    private JRadioButton normal;
    private JRadioButton evenly;
    private JTextField number;

    private JButton calculateBtn;
    private JButton generatePointsBtn;
    private JButton upload;
    private JFileChooser chooser = new JFileChooser();
    ButtonGroup points = new ButtonGroup();
    DrawArea drawArea = new DrawArea();
    ArrayList<Point> mnogokotnik = new ArrayList<>();
    AlgoritemPoltraku algoritemPoltraku = new AlgoritemPoltraku();
    AlgoritemEnakihPredznakov algoritemEnakihPredznakov = new AlgoritemEnakihPredznakov();
    AlgoritemVsoteKotov algoritemVsoteKotov = new AlgoritemVsoteKotov();


    ActionListener generatingPoints = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int n;
            drawArea.clear();

            if (normal.isSelected()) {
                n = Integer.parseInt(number.getText());

                drawArea.drawingPointsNormaly(n);

            } else if (evenly.isSelected()) {
                n = Integer.parseInt(number.getText());

                drawArea.drawingPointsEvenly(n);

            }

        }
    };

    ActionListener solution = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (poltrak.isSelected()) {

                ArrayList<Point> solution = new ArrayList<>();
                ArrayList<Point> test = new ArrayList<>();
                test.add(new Point(200, 300));
                System.out.println("test");
                solution = algoritemPoltraku.algoritamPoltraku(mnogokotnik, drawArea.getPoints());

                for (int i = 0; i < solution.size(); i++)
                    System.out.println("solution" + solution.get(i).x);

                drawArea.drawSolution(solution);
                solution.clear();


            } else if (vsotaKotov.isSelected()) {

                ArrayList<Point> solution = new ArrayList<>();
                ArrayList<Point> test = new ArrayList<>();
                test.add(new Point(400, 300));
                System.out.println("test");
                solution = algoritemVsoteKotov.algoritemVsoteKotov(mnogokotnik, drawArea.getPoints());
                //solution = algoritemVsoteKotov.algoritemVsoteKotov(mnogokotnik, test);

                System.out.println(solution.size());
                for (int i = 0; i < solution.size(); i++)
                    System.out.println("solution" + solution.get(i).x + " " + solution.get(i).y);

                drawArea.drawSolution(solution);
                solution.clear();


            } else if (enakiPredznaki.isSelected()) {

                ArrayList<Point> solution = new ArrayList<>();
                ArrayList<Point> test = new ArrayList<>();
                test.add(new Point(400, 400));
                System.out.println("test");
                solution = algoritemEnakihPredznakov.algoritemEnakihPredznakov(mnogokotnik, drawArea.getPoints());

                System.out.println(solution.size());
                for (int i = 0; i < solution.size(); i++)
                    System.out.println("solution" + solution.get(i).x + " " + solution.get(i).y);

                drawArea.drawSolution(solution);
                solution.clear();

            }

        }
    };

    ActionListener uploadActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            mnogokotnik.clear();
           int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " +
                        chooser.getSelectedFile().getName());
            }


              File file = new File(chooser.getSelectedFile().getAbsolutePath());
            //File file= new File("C:\\Users\\Korisnik\\IdeaProjects\\vaja5_urvg\\src\\com\\company\\test.pts");
           //File file = new File("C:\\Users\\Korisnik\\IdeaProjects\\vaja5_urvg\\src\\com\\company\\jjj.pts");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }


            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");

                System.out.println(Double.parseDouble(fields[0]));
               // mnogokotnik.add(new Point(Double.parseDouble(fields[0]), Double.parseDouble(fields[1])));
                mnogokotnik.add(new Point(Double.parseDouble(fields[0]) * 1000, Double.parseDouble(fields[1]) * 1000));
            }
            scanner.close();

            drawArea.drawingDaljice(mnogokotnik);

            for (int i = 0; i < mnogokotnik.size(); i++)
                System.out.println(mnogokotnik.get(i).x);
            // System.out.println(mnogokotnik);


        }
    };

    public void show() {

        // create main frame
        JFrame frame = new JFrame("App");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());

        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(16, 1));

        calculateBtn = new JButton("Izracunaj");
        calculateBtn.addActionListener(solution);
        generatePointsBtn = new JButton("Generiraj tocke");
        generatePointsBtn.addActionListener(generatingPoints);
        upload = new JButton("Upload");
        upload.addActionListener(uploadActionListener);

        number = new JTextField(5);
        number.setText("100");
        algorithm = new JLabel("Algoritmi: ");
        placementOfPoints = new JLabel("Porazdelitev tock: ");
        numberOfPoints = new JLabel("St. navkljucnih tock: ");

        poltrak = new JRadioButton("Algoritem poltraka");
        vsotaKotov = new JRadioButton("Algoritem vsote kotov");
        enakiPredznaki = new JRadioButton("Algoritem enakih predznakov");

        ButtonGroup algorithams = new ButtonGroup();
        algorithams.add(poltrak);
        algorithams.add(vsotaKotov);
        algorithams.add(enakiPredznaki);

        normal = new JRadioButton("Normalna");
        evenly = new JRadioButton("Enakomerno");


        points.add(normal);
        points.add(evenly);

        controls.add(upload);
        controls.add(algorithm);
        controls.add(poltrak);
        controls.add(vsotaKotov);
        controls.add(enakiPredznaki);
        controls.add(placementOfPoints);
        controls.add(normal);
        controls.add(evenly);
        controls.add(numberOfPoints);
        controls.add(number);
        controls.add(generatePointsBtn);
        controls.add(calculateBtn);

        // add to content pane
        content.add(controls, BorderLayout.WEST);
        content.add(drawArea, BorderLayout.CENTER);
        //content.add(controls, BorderLayout.SOUTH);

        frame.setSize(850, 700);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show
        frame.setVisible(true);


    }


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // write your code here
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new Main().show();
    }
}

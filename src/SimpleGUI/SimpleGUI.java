package SimpleGUI;

/**
 * Created by minosyan_ak on 09.12.2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGUI extends JFrame {
    public TextField countLabel;
    //public TextField countLabel1;
    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton summ;
    private JButton multiplication;
    private JButton subtraction;
    private JButton segmentation;
    private JButton eq;
    private JButton Del;
    private JButton polsk;
    private double f_num, c;
    private String f = "", s = "", k1 = "";
    public int l = 0;

    public SimpleGUI() {
        super("Calculator");
        countLabel = new TextField(12);
        summ = new JButton("+");
        multiplication = new JButton("*");
        subtraction = new JButton("-");
        segmentation = new JButton("/");
        eq = new JButton("=");
        Del = new JButton("C");
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        polsk = new JButton("polsk");

        countLabel.setBounds(10, 10, 260, 30);
        summ.setBounds(220, 60, 50, 50);
        multiplication.setBounds(220, 120, 50, 50);
        subtraction.setBounds(220, 180, 50, 50);
        segmentation.setBounds(220, 240, 50, 50);
        eq.setBounds(150, 240, 50, 50);
        Del.setBounds(10, 240, 50, 50);
        one.setBounds(10, 60, 50, 50);
        two.setBounds(80, 60, 50, 50);
        three.setBounds(150, 60, 50, 50);
        four.setBounds(10, 120, 50, 50);
        five.setBounds(80, 120, 50, 50);
        six.setBounds(150, 120, 50, 50);
        seven.setBounds(10, 180, 50, 50);
        eight.setBounds(80, 180, 50, 50);
        nine.setBounds(150, 180, 50, 50);
        zero.setBounds(80, 240, 50, 50);
        polsk.setBounds(70, 300, 140, 50);

        setLayout(null);

        add(countLabel);
        add(summ);
        add(multiplication);
        add(subtraction);
        add(segmentation);
        add(eq);
        add(Del);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);
        add(zero);
        add(polsk);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (countLabel.getText().equals("")) countLabel.setText("");
                else
                    countLabel.setText(countLabel.getText() + "0");
            }
        });
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "1");
            }
        });
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "2");
            }
        });
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "3");
            }
        });
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "4");
            }
        });
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "5");
            }
        });
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "6");
            }
        });
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "7");
            }
        });
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "8");
            }
        });
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countLabel.setText(countLabel.getText() + "9");
            }
        });
        summ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                oper("+");
                //f = "+";
                //l++;
                countLabel.setText("");
            }
        });
        subtraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oper("-");
                /// l++;
                countLabel.setText("");
            }
        });
        multiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oper("*");
                // l++;
                countLabel.setText("");
            }
        });
        segmentation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oper("/");
                //l++;
                countLabel.setText("");
            }
        });
        eq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oper("=");
                countLabel.setText(String.valueOf(c));
            }
        });
        Del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                oper("del");

            }
        });
        polsk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Pattern p = Pattern.compile("^[(0-9)|(+)|(-)|(*)|(/)|(^)|-]+");
                    String f = countLabel.getText();
                    Matcher m = p.matcher(f);
                    int o = 0;
                    char[] calc = f.toCharArray();
                    for (int i = 0; i < f.length(); i++) {
                        if (calc[i] == '(') o++;
                        if (calc[i] == ')') o--;
                    }
                    //if()){countLabel.setText("Incorrectly entered string");}
                    if (!(m.matches()) ||
                            f.contains("++") ||
                            f.contains("+-") ||
                            f.contains("+*") ||
                            f.contains("+/") ||
                            f.contains("+^") ||
                            f.contains("-+") ||
                            f.contains("--") ||
                            f.contains("-*") ||
                            f.contains("-/") ||
                            f.contains("-^") ||
                            f.contains("*+") ||
                            f.contains("*-") ||
                            f.contains("**") ||
                            f.contains("*/") ||
                            f.contains("*^") ||
                            f.contains("/+") ||
                            f.contains("/-") ||
                            f.contains("/*") ||
                            f.contains("//") ||
                            f.contains("/^") ||
                            f.contains("^+") ||
                            f.contains("^-") ||
                            f.contains("^*") ||
                            f.contains("^/") ||
                            f.contains("^^") ||
                            f.startsWith("*") ||
                            f.startsWith("/") ||
                            f.startsWith("^") ||
                            f.endsWith("+") ||
                            f.endsWith("-") ||
                            f.endsWith("/") ||
                            f.endsWith("^") ||
                            o != 0) countLabel.setText("Incorrectly entered string");
                    else countLabel.setText(Polskaya.main(countLabel.getText()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

    public void oper(String k) {


        if (k.equals(k1)) System.out.println("123");
        else if (k1.equals("=")) s = "";
        else {
            f_num = Double.parseDouble(countLabel.getText());
        }

        //countLabel.setText("");

        if (s.equals("")) {
            c = Double.parseDouble(countLabel.getText());
            f_num = 0;
        } else {
            switch (s) {
                case "=":
                    if (s.equals("+")) {
                        c = Calculation.summ(c, f_num);
                    }
                    if (s.equals("-")) {
                        c = Calculation.subtraction(c, f_num);
                    }
                    if (s.equals("/")) {
                        c = Calculation.segmentation(c, f_num);
                    }
                    if (s.equals("*")) {
                        c = Calculation.multiplication(c, f_num);
                    }
                    System.out.println(c);

                case "+":
                    c = Calculation.summ(c, f_num);
                    // f_num = 0;
                    break;
                case "-":
                    c = Calculation.subtraction(c, f_num);
                    // f_num = 0;
                    break;
                case "*":
                    c = Calculation.multiplication(c, f_num);
                    /// f_num = 1;
                    break;
                case "/":
                    c = Calculation.segmentation(c, f_num);
                    // f_num = 1;
                    break;
                case "del":
                    f_num = 0;
                    c = 0;
                    s = "";
                    k1 = "";
                    k = "";
                    countLabel.setText("");
                    break;
            }
        }
        if (k.equals("=")) k1 = k;
        else {
            s = k;
            k1 = "";
        }
        System.out.println(s);

    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
        app.setBounds(80, 80, 300, 400);
    }
}

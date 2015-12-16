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

public class Graphics extends JFrame implements ActionListener {
    public static final int BUTTON_HEIGHT = 50;
    public static String SUMM = "+";
    public static String MULTIPLICATION = "*";
    public static String SUBSTRACTION = "-";
    public static String SEGMETATION = "/";
    public static String EQ = "=";
    public static String DEL = "C";
    public static String ZERO = "0";
    public static String ONE = "1";
    public static String TWO = "2";
    public static String THREE = "3";
    public static String FOUR = "4";
    public static String FIVE = "5";
    public static String SIX = "6";
    public static String SEVEN = "7";
    public static String EIGHT = "8";
    public static String NINE = "9";
    public static String POLSK = "POLSK";
    public TextField countLabel;
    private JButton zeroButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton summButton;
    private JButton multiplicationButton;
    private JButton subtractionButton;
    private JButton segmentationButton;
    private JButton eqButton;
    private JButton delButton;
    private JButton polskButton;
    private double secondNumeric, firstNumeric;
    private String peiviousOperator = "", k1 = "";

    enum Season {
        ONE("1");


        String name;

        Season(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public Graphics() {
        super("Calculator");
        countLabel = new TextField(12);
        summButton = new JButton(SUMM);
        multiplicationButton = new JButton(MULTIPLICATION);
        subtractionButton = new JButton(SUBSTRACTION);
        segmentationButton = new JButton(SEGMETATION);
        eqButton = new JButton(EQ);
        delButton = new JButton(DEL);
        zeroButton = new JButton(ZERO);
        oneButton = new JButton(ONE);
        twoButton = new JButton(TWO);
        threeButton = new JButton(THREE);
        fourButton = new JButton(FOUR);
        fiveButton = new JButton(FIVE);
        sixButton = new JButton(SIX);
        sevenButton = new JButton(SEVEN);
        eightButton = new JButton(EIGHT);
        nineButton = new JButton(NINE);
        polskButton = new JButton(POLSK);

        countLabel.setBounds(10, 10, 260, 30);
        summButton.setBounds(220, 60, 50, 50);
        multiplicationButton.setBounds(220, 120, 50, BUTTON_HEIGHT);
        subtractionButton.setBounds(220, 180, 50, BUTTON_HEIGHT);
        segmentationButton.setBounds(220, 240, 50, BUTTON_HEIGHT);
        eqButton.setBounds(150, 240, 50, BUTTON_HEIGHT);
        delButton.setBounds(10, 240, 50, BUTTON_HEIGHT);
        oneButton.setBounds(10, 60, 50, BUTTON_HEIGHT);
        twoButton.setBounds(80, 60, 50, BUTTON_HEIGHT);
        threeButton.setBounds(150, 60, 50, BUTTON_HEIGHT);
        fourButton.setBounds(10, 120, 50, BUTTON_HEIGHT);
        fiveButton.setBounds(80, 120, 50, BUTTON_HEIGHT);
        sixButton.setBounds(150, 120, 50, BUTTON_HEIGHT);
        sevenButton.setBounds(10, 180, 50, BUTTON_HEIGHT);
        eightButton.setBounds(80, 180, 50, BUTTON_HEIGHT);
        nineButton.setBounds(150, 180, 50, BUTTON_HEIGHT);
        zeroButton.setBounds(80, 240, 50, BUTTON_HEIGHT);
        polskButton.setBounds(70, 300, 140, BUTTON_HEIGHT);

        add(countLabel);
        add(summButton);
        add(multiplicationButton);
        add(subtractionButton);
        add(segmentationButton);
        add(eqButton);
        add(delButton);
        add(oneButton);
        add(twoButton);
        add(threeButton);
        add(fourButton);
        add(fiveButton);
        add(sixButton);
        add(sevenButton);
        add(eightButton);
        add(nineButton);
        add(zeroButton);
        add(polskButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zeroButton.addActionListener(this);
        oneButton.addActionListener(this);
        twoButton.addActionListener(this);
        threeButton.addActionListener(this);
        fourButton.addActionListener(this);
        fiveButton.addActionListener(this);
        sixButton.addActionListener(this);
        sevenButton.addActionListener(this);
        eightButton.addActionListener(this);
        nineButton.addActionListener(this);
        summButton.addActionListener(this);
        multiplicationButton.addActionListener(this);
        subtractionButton.addActionListener(this);
        segmentationButton.addActionListener(this);
        eqButton.addActionListener(this);
        polskButton.addActionListener(this);
        delButton.addActionListener(this);

    }

    private void initializeButton(int i, int j) {

    }

    public void oper(String k) {
        // if(countLabel.getText().equals("")&&k.equals("=")&&firstNumeric==0){}
        //else {
        if (!k.equals(k1) && k1.equals("=")) {
            peiviousOperator = "";
        } else {
            secondNumeric = Double.parseDouble(countLabel.getText());
        }
        if (peiviousOperator.equals("")) {
            firstNumeric = Double.parseDouble(countLabel.getText());
            secondNumeric = 0;
            countLabel.setText("");
        } else {
            switch (peiviousOperator) {
                case "=":
                    if (peiviousOperator.equals("+")) {
                        firstNumeric = Calculation.summ(firstNumeric, secondNumeric);
                        countLabel.setText("");
                    }
                    if (peiviousOperator.equals("-")) {
                        firstNumeric = Calculation.subtraction(firstNumeric, secondNumeric);
                        countLabel.setText("");
                    }
                    if (peiviousOperator.equals("/")) {
                        firstNumeric = Calculation.segmentation(firstNumeric, secondNumeric);
                        countLabel.setText("");
                    }
                    if (peiviousOperator.equals("*")) {
                        firstNumeric = Calculation.multiplication(firstNumeric, secondNumeric);
                        countLabel.setText("");
                    }

                    System.out.println(firstNumeric);

                case "+":
                    firstNumeric = Calculation.summ(firstNumeric, secondNumeric);
                    countLabel.setText("");
                    break;
                case "-":
                    firstNumeric = Calculation.subtraction(firstNumeric, secondNumeric);
                    countLabel.setText("");
                    break;
                case "*":
                    firstNumeric = Calculation.multiplication(firstNumeric, secondNumeric);
                    countLabel.setText("");
                    break;
                case "/":
                    firstNumeric = Calculation.segmentation(firstNumeric, secondNumeric);
                    countLabel.setText("");
                    break;
            }
        }
        if (k.equals("=")) {
            k1 = k;
        } else {
            peiviousOperator = k;
            k1 = "";
        }
        System.out.println(peiviousOperator);
    }

    public void proverka(String k) {
        Pattern p = Pattern.compile("^[0-9|.|E|-]+");
        String f = countLabel.getText();
        Matcher m = p.matcher(f);
        if (k.equals("del")) {
            secondNumeric = 0;
            firstNumeric = 0;
            peiviousOperator = "";
            k1 = "";
            k = "";
            countLabel.setText("");
        }
        if (countLabel.getText().equals("") && !(peiviousOperator.equals(""))) {
            peiviousOperator = k;
        } else if (countLabel.getText().equals("")) {
            firstNumeric = 0;
            peiviousOperator = k;
        } else if (!(m.matches())) {
            countLabel.setText("Incorrectly entered string");
        } else {
            oper(k);
        }

    }

    public static void main(String[] args) {
        Graphics app = new Graphics();
        app.setVisible(true);
        app.setBounds(80, 80, 300, 400);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "0":
                if (!(countLabel.getText().equals(""))) {
                    countLabel.setText(countLabel.getText() + "0");
                }
                break;
            case "1":
                countLabel.setText(countLabel.getText() + "1");
                break;
            case "2":
                countLabel.setText(countLabel.getText() + "2");
                break;
            case "3":
                countLabel.setText(countLabel.getText() + "3");
                break;
            case "4":
                countLabel.setText(countLabel.getText() + "4");
                break;
            case "5":
                countLabel.setText(countLabel.getText() + "5");
                break;
            case "6":
                countLabel.setText(countLabel.getText() + "6");
                break;
            case "7":
                countLabel.setText(countLabel.getText() + "7");
                break;
            case "8":
                countLabel.setText(countLabel.getText() + "8");
                break;
            case "9":
                countLabel.setText(countLabel.getText() + "9");
                break;
            case "+":
                proverka("+");
                break;
            case "*":
                proverka("*");
                break;
            case "-":
                proverka("-");
                break;
            case "/":
                proverka("/");
                break;
            case "=":
                proverka("=");
                countLabel.setText(String.valueOf(firstNumeric));
                break;
            case "C":
                proverka("del");
                break;
            case "POLSK":
                try {
                    Pattern enabledSymbols = Pattern.compile("^[(0-9)|(+)|(-)|(*)|(/)|(^)|-]+");
                    Pattern disabledSymbols = Pattern.compile("[(+)|(-)|(*)|(/)|(^)|-][(+)|(-)|(*)|(/)|(^)|-]");
                    String countLabelText = countLabel.getText();
                    Matcher enabledMatcher = enabledSymbols.matcher(countLabelText);
                    Matcher disabledMatcher = disabledSymbols.matcher(countLabelText);
                    int counter = 0;
                    char[] charArray = countLabelText.toCharArray();
                    for (int i = 0; i < countLabelText.length(); i++) {
                        if (charArray[i] == '(') {
                            counter++;
                        }
                        if (charArray[i] == ')') {
                            counter--;
                        }
                    }
                    if (!(enabledMatcher.matches()) ||
                            disabledMatcher.matches() ||
                            countLabelText.startsWith("*") ||
                            countLabelText.startsWith("/") ||
                            countLabelText.startsWith("^") ||
                            countLabelText.endsWith("+") ||
                            countLabelText.endsWith("-") ||
                            countLabelText.endsWith("/") ||
                            countLabelText.endsWith("^") ||
                            counter != 0) {
                        countLabel.setText("Incorrectly entered string");
                    } else {
                        countLabel.setText(Polskaya.main(countLabel.getText()));
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                break;
            default:
                countLabel.setText("Incorrectly entered string");
        }
    }
}

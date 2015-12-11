package SimpleGUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Character.isDigit;

/**
 * Created by minosyan_ak on 10.12.2015.
 */
public class Polskaya {
    public static String main(String name) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String name = reader.readLine();
        if(name.startsWith("+"))name = name.substring(1);
        for(int i = 0;i<name.length();i++) {
            char[] calc1 = name.toCharArray();
            if(calc1[i] == '(' && calc1[i+1] == '+'){
                name = name.substring(0,i+1)+name.substring(i+2,name.length());
            }
        }

        for(int i = 0;i<(name.length()-1);i++) {
            char[] calc1 = name.toCharArray();
            if(calc1[i] == '(' && calc1[i+1] == '+'){
                name = name.substring(0,i+1)+name.substring(i+2,name.length());
            }
            if( isDigit(calc1[i]) && calc1[i+1] == '('){
                name = name.substring(0,i+1) + "*"  + name.substring(i+1,name.length());
            }
            if( calc1[i] == ')' && isDigit(calc1[i+1])){
                name = name.substring(0,i+1) + "*" + name.substring(i+1,name.length());
            }
            if( calc1[i] == ')' && calc1[i+1] == '('){
                name = name.substring(0,i+1) + "*" + name.substring(i+1,name.length());
            }
        }
        char[] calc = name.toCharArray();
        String[] num = new String[54];
        String[] oper = new String[50];
        int i_num = 0;
        int i_oper = 0;
        int prior = 5;
        for (int k = 0; k < 50; k++) {
            oper[k] = "";
            num[k] = "";
        }
//        for (int i = 0; i < name.length(); i++){
//        if(calc[0]=='0'){
//            for (int k = 0;k <= name.length();k++)
//                calc[k]
//        }
//        }
        for (int i = 0; i < name.length(); i++)
            if (calc[i] >= '0' && calc[i] <= '9') {
                num[i_num] += calc[i];
                num[i_num] = num[i_num].trim();
            } else {
                if (i_oper == 0) {
                    if(calc[i] == '-')num[i_num] = "0";
                    oper[i_oper] = String.valueOf(calc[i]);
                    i_oper++;
                    if (oper[i_oper - 1].equals("(")) i_num--;}
                else {
                    switch (calc[i]) {
                        case '+':
                            while (i_oper != 0) {
                                if (oper[i_oper - 1].equals("(")) {
                                    break;
                                } else {
                                    num[i_num += 1] = oper[i_oper -= 1];
                                    oper[i_oper] = "";
                                }
                            }
                            oper[i_oper] = String.valueOf(calc[i]);
                            i_oper++;
                            break;
                        case '-':
                            while (i_oper != 0) {
                                //if (oper[i_oper - 1].equals("-") ) {}
                                if (oper[i_oper - 1].equals("(") ) {
                                    num[i_num] = "0";
                                    break;
                                } else {
                                    num[i_num += 1] = oper[i_oper -= 1];
                                    oper[i_oper] = "";
                                    if (i_oper != 0){if(oper[i_oper - 1].equals("("))break;}
                                }
                            }
                            oper[i_oper] = String.valueOf(calc[i]);
                            i_oper++;
                            break;
                        case '*':
                            while (i_oper != 0) {
                                if (oper[i_oper - 1].equals("+") || oper[i_oper - 1].equals("-") || oper[i_oper - 1].equals("(") || oper[i_oper - 1].equals("("))
                                    break;
                                else {
                                    num[i_num += 1] = oper[i_oper -= 1];
                                    oper[i_oper] = "";
                                }
                            }
                            oper[i_oper] = String.valueOf(calc[i]);
                            i_oper++;
                            break;
                        case '/':
                            while (i_oper != 0) {
                                if (oper[i_oper - 1].equals("+") || oper[i_oper - 1].equals("-") || oper[i_oper - 1].equals("(") || oper[i_oper - 1].equals("("))
                                    break;
                                else {
                                    num[i_num += 1] = oper[i_oper -= 1];
                                    oper[i_oper] = " ";
                                }
                            }
                            oper[i_oper] = String.valueOf(calc[i]);
                            i_oper++;
                            break;
                        case '^':
                            while (true) {
                                if (oper[i_oper - 1].equals("^")) {
                                    num[i_num += 1] = oper[i_oper -= 1];
                                    oper[i_oper] = "";
                                } else break;
                            }
                            oper[i_oper] = String.valueOf(calc[i]);
                            i_oper++;
                            prior = 3;
                            break;
                        case '(':
                            oper[i_oper] = String.valueOf(calc[i]);
                            i_oper++;
                            i_num--;
                            break;

                        case ')':
                            while (true) {
                                if (i_oper == 0 || oper[i_oper - 1].equals("(")) {
                                    oper[i_oper -= 1] = "";
                                    break;
                                } else {
                                    num[i_num += 1] = oper[i_oper -= 1];
                                    oper[i_oper] = "";
                                }
                            }
                            i_num--;
                            break;
                    }
                }
                i_num++;
            }
        String[] name1 = num;
        int p = 0;
        for (; p < 50; p++) {
            if (oper[p].equals("")) break;
        }
        for (p -= 1; p >= 0; p--) {
            i_num++;
            num[i_num] = oper[p];
        }
         System.out.println(i_num);
               ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(num));
               System.out.println(arrayList);
        for (int j = 0; j <= i_num; j++) {
            if (num[j].equals("+") || num[j].equals("-") || num[j].equals("*") || num[j].equals("/") || num[j].equals("^")) {
                double f_num = Double.parseDouble(num[j - 2]);
                double s_num = Double.parseDouble(num[j - 1]);
                double c = 0;
                switch (num[j]) {
                    case "*":
                        c = Calculation.multiplication(f_num, s_num);
                        //System.out.println(c);
                        break;
                    case "+":
                        c = Calculation.summ(f_num, s_num);
                        break;
                    case "-":
                        c = Calculation.subtraction(f_num, s_num);
                        break;
                    case "/":
                        c = Calculation.segmentation(f_num, s_num);
                        break;
                    case "^":
                        c = Calculation.sqrt(f_num, s_num);
                }
                num[j - 2] = String.valueOf(c);
                for (int i = j; i < i_num; i++) {
                    num[i - 1] = num[i + 1];
                }
                if (j == i_num) break;
                i_num -= 2;

                j = 0;
            }
        }
        System.out.println(num[0]);
//        int i = Integer.parseInt(num[0]);
//        try{
//            //int i = Integer.parseInt(num[0]);
//        System.out.println(i);
//        }
//        catch(NumberFormatException e){
//        System.out.println(num[0]);
//        }

    return num[0];
    }

}

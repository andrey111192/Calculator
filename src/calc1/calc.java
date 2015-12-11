package calc1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * Created by minosyan_ak on 09.12.2015.
 */

public class calc {
    public static void main(String[] args) throws IOException {
        int c, f_num , s_num;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the first number");
        while(true) {
            try {
                String f = reader.readLine();
                f_num = Integer.parseInt(f);
                break;
            } catch (Exception calc) {
                System.out.println("You have entered an incorrect number");
                System.out.println("Enter again the first number");
            }
        }
        System.out.println("Enter the operand");
        String oper = reader.readLine();
        while(!oper.equals("*") && !oper.equals("/") && !oper.equals("+") && !oper.equals("-")){
            System.out.println("You enter wrong operand");
            System.out.println("Enter again the operand");
            String oper1 = reader.readLine();
            oper = oper1;
        }
        System.out.println("Enter the second number");
        while(true) {
            try {
                String s = reader.readLine();
                s_num = Integer.parseInt(s);
                break;
            } catch (Exception calc) {
                System.out.println("You have entered an incorrect number");
                System.out.println("Enter again the Second number");
            }
        }
        calculation calc1 = new calculation();
        switch(oper) {
            case "*": oper = "*";
                c = calc1.multiplication(f_num, s_num);
                System.out.println(c);
                break;
            case "+":
                c = calc1.summ(f_num, s_num);
                System.out.println(c);
                break;
            case "-":
                c = calc1.subtraction(f_num, s_num);
                System.out.println(c);
                break;
            case "/":
                c = calc1.segmentation(f_num, s_num);
                System.out.println(c);
                break;
        }
    }


}
class calculation {
    public static int summ(int f, int s){
        return f+s;
    }
    public static int multiplication(int f, int s){
        return f*s;
    }
    public static int segmentation(int f, int s){
        return f/s;
    }
    public static int subtraction(int f, int s){
        return f-s;
    }
}
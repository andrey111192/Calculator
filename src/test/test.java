package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

/**
 * Created by minosyan_ak on 11.12.2015.
 */
public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        char[] calc = name.toCharArray();
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
        System.out.print(name);
    }
    }



package com.company;

import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class Main {
    static int n, m;//значения
    static String a = "  ", b = "  "; //переходные значения n & m
    static String operation = " "; //арифметическая операция
    static boolean bool = true, n1, m1; //клеймо n & m арабские или римские (false = арабские)
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введи выражение: ");
        String input = scanner.nextLine(); //считываем выражение

        Operation(input);

        a = RimToArab(a);
        n1 = bool;
        bool = true;
        b = RimToArab(b);
        m1 = bool;


        // исключение для услвоия 4
        n =  IntegerCalcException(a);
        m =  IntegerCalcException(b);

        // исключение для условия 3
        RangeCalcException(n, m);

        // исключение для условия 5
        RimArabCalcException(n1, m1);

        //переводим все в одну систему
        String result = calc(operation, n, m);
        int resultt = Integer.parseInt(result);
        if (bool == true) result = ArabToRim(resultt);


        System.out.print(result);
    }


    public static String calc(String operation, int first, int second) {
        switch (operation) {
            case "+":
                return Integer.toString(first + second);
            case "-":
                return Integer.toString(first - second);
            case "*":
                return Integer.toString(first * second);
            case "/":
                return Integer.toString(first / second);
        }
        return " ";
    }


    private static void Operation(String input) {
        //определение значения и операции

        char symbol; //переходное значение operation
        for (int i = 0; i < input.length(); i++) {
            symbol = input.charAt(i);
            if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {

                if (symbol == '+') operation = "+";
                if (symbol == '-') operation = "-";
                if (symbol == '*') operation = "*";
                if (symbol == '/') operation = "/";

                a = input.substring(0, i);
                b = input.substring(i + 1);
            }

        }
    }

    private static String RimToArab(String Rim) {
        switch (Rim) {
            case "I":
                return "1";
            case "II":
                return "2";
            case "III":
                return "3";
            case "IV":
                return "4";
            case "V":
                return "5";
            case "VI":
                return "6";
            case "VII":
                return "7";
            case "VIII":
                return "8";
            case "IX":
                return "9";
            case "X":
                return "10";
        }
        bool = false;
        return Rim;
    }


    private static String ArabToRim(int result) {
        String[] Rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",  "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",  "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",  "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",  "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C" };
        String s = Rim[result];
        return s;
    }

    // все исключения


    private static void RangeCalcException(int a, int b) {
        try {
            if (1 > a || a > 10 || 1 > b || b > 10) throw new Exception("Введите числа от 1 до 10");
        } catch (Exception ex) {
            System.out.println("Exception" + "\n" + ex.getMessage());
            System.exit(0); // возвращаем 0 в случае возникновения исключения
        }
    }


    private static int IntegerCalcException(String b) throws NumberFormatException {

        double a;
        try {
            a = Double.parseDouble(b);
        } catch (NumberFormatException ex) {
            System.out.println("Exception");
            System.exit(0);
        }

        a = Double.parseDouble(b);
        try {
            if (a % 1 != 0) throw new NumberFormatException("Введите целые числа");
        } catch (NumberFormatException ex) {
            System.out.println("Exception" + "\n" + ex.getMessage());
            System.exit(0);
        }
        return (int) a;
    }


    private static void RimArabCalcException(boolean a, boolean b ){
        try {
            if (a != b) throw new Exception("Введите числа одного типа");
            if (bool == true && n < m) throw new Exception("Результат не может быть отрицательный, \nкогда используются римские цифры");
        }
        catch (Exception ex){
            System.out.println("Exception" + "\n" + ex.getMessage());
            System.exit(0);
        }
    }


}
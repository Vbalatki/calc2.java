package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main  {
    public static void main(String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введи выражение: ");
        String input = scanner.nextLine(); //считываем выражение
        String a = " ";
        try {
            a = Calc.calc(input);
        }catch (InputMismatchException e){
            System.out.print(e.getMessage());
            System.exit(0);
        }
        System.out.println(a);
    }
}
public class Calc {
    static int n, m;//значения
    static String a, b; //переходные значения n & m
    static String operation = " "; //арифметическая операция
    static boolean n1 = false, m1 = false; //клеймо n & m арабские или римские (false = арабские)
    static Scanner scanner = new Scanner(System.in);


    public static String calc(String input) throws InputMismatchException{

        Operation(input); //разбивает числа и символы в отдельные поля

        //проверка на алфавит символов
        String[] Rim = {"1", "2", "3", "4",  "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < 10; i++){
            if (a.equals(Rim[i])) n1 = true;
            if (b.equals(Rim[i])) m1 = true;
        }
        if (n1 != m1) throw new InputMismatchException("Некорректное выражение");

        m = RimToArab(a);
        n = RimToArab(b);


        //переводим все в одну систему
        String result = Symbol(operation, m, n);
        int resultt = Integer.parseInt(result);
        if (n1 != true) result = ArabToRim(resultt);


        return result;
    }


    private static void Operation(String input) throws InputMismatchException{
        //определение значения и операции

        char symbol = ' '; //переходное значение operation
        for (int i = 0; i < input.length(); i++) {
            symbol = input.charAt(i);

            if (symbol == '.') throw new InputMismatchException("Введите целые числа");
            if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {

                if (symbol == '+') operation = "+";
                if (symbol == '-') operation = "-";
                if (symbol == '*') operation = "*";
                if (symbol == '/') operation = "/";

                a = input.substring(0, i);
                b = input.substring(i + 1);
            }

        }
        if (operation == " ") throw new InputMismatchException("Некорректное выражение");
    }

    private static int RimToArab(String Rim) throws InputMismatchException {
        switch (Rim) {
            case "I", "1":
                return 1;
            case "II", "2":
                return 2;
            case "III", "3":
                return 3;
            case "IV", "4":
                return 4;
            case "V", "5":
                return 5;
            case "VI", "6":
                return 6;
            case "VII", "7":
                return 7;
            case "VIII", "8":
                return 8;
            case "IX", "9":
                return 9;
            case "X", "10":
                return 10;
            default:
                throw new InputMismatchException("Некорректное выражение");
        }
    }

    private static String Symbol(String operation, int first, int second) throws InputMismatchException{
        switch (operation) {
            case "+":
                return Integer.toString(first + second);
            case "-":
                if (n1 == false && first - second < 1) throw new InputMismatchException("Результат работы с римскими числами не может быть меньше единицы");

                else return Integer.toString(first - second);
            case "*":
                return Integer.toString(first * second);
            case "/":
                return Integer.toString(first / second);
        }
        return " ";
    }


    private static String ArabToRim(int result) {
        String[] Rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String s = Rim[result];
        return s;
    }
}

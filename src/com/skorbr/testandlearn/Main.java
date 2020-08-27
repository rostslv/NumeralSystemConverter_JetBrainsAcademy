package com.skorbr.testandlearn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input a base numeric system: ");
            int radixBase = scanner.nextInt();
            System.out.println("Input a number: ");
            String number = scanner.next();
            System.out.println("Input a target numeric system: ");
            int radixTo = scanner.nextInt();
            //проверка на валидность системы счисления
            if ((radixBase > 0 && radixTo > 0) && (radixBase < 37 && radixTo <37)) {
                //проверка на тип числа (int/double)
                if (number.contains(".") == false) {
                    Converter.convert(radixBase, number, radixTo, false);
                } else {
                    Converter.convert(radixBase, number, radixTo, true);
                }
            } else {
                System.err.println("Error! Radix can`t be 0 and > 36");
            }
        } catch (Exception e) {
            System.err.println("Input error!");
        }
    }
}


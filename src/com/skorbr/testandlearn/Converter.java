package com.skorbr.testandlearn;

public class Converter {

    public static void convert(int radixBase, String number, int radixTo, boolean isFractional) {
        //перевод целого числа
        if (isFractional == false) {
            if (radixBase != 1 && radixTo != 1) {
                System.out.print("Result: " + Integer.toString(Integer.parseInt(number, radixBase), radixTo));
            } else {
                //если изначальная система счисления = 1 -> вычисляем число единиц (приводим к 10 системе)
                // -> приводим к нужной системе счисления и выводим
                if (radixBase == 1) {
                    int numCountOnes = 0;
                    for (int i = 0; i < String.valueOf(number).length(); i++) {
                        numCountOnes++;
                    }
                    System.out.print("Result: " + Integer.toString(numCountOnes, radixTo));
                }
                //если целевая система счисления = 1 -> приводим число к 10 системе
                // -> выводим число единиц
                if (radixTo == 1) {
                    int decFromNumber = Integer.parseInt(number, radixBase);
                    System.out.println("Result: ");
                    for (int i = 0; i < decFromNumber; i++) {
                        System.out.print(1);
                    }
                }
            }
        //перевод числа с плавающей запятой
        } else {
            String[] numbers = number.split("\\.");
            //конвертация целой части в нужную систему и вывод ее
            String intPart = Integer.toString(Integer.parseInt(numbers[0], radixBase), radixTo);
            //конвертация дробной части в 10 систему
            double decPart = 0;
            for (int i = 0; i < numbers[1].length(); i++) {
                decPart += Character.getNumericValue(numbers[1].charAt(i)) / Math.pow(radixBase, i + 1);
            }
            //конвертация дробной части в нужную систему
            //в соответствии с формулой (получаем 5 символов после точки)
            StringBuilder decPartStr = new StringBuilder();
            decPart = decPart * radixTo;
            //первый символ
            if ((int) decPart >= 10) {
                decPartStr.append(Character.forDigit((int) decPart, radixTo));
            } else {
                decPartStr.append((int) decPart);
            }
            //последние 4
            for (int i = 0; i < 4; i++) {
                decPart = decPart - (int) decPart;
                decPart *= radixTo;
                if (decPart >= 10) {
                    decPartStr.append(Character.forDigit((int) decPart, radixTo));
                } else {
                    decPartStr.append((int) decPart);
                }
            }
            System.out.print("Result: " + intPart + "." + decPartStr);
        }
    }
}

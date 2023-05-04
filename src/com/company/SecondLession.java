package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SecondLession {
    static BufferedReader br = null;
    public static void main(String[] args) {
//        1
        try {
            System.out.println("Введите дробное число");
            gameNum();
        } catch (ClassCastException e){
            System.out.println("Введено не число");
        } finally {
            System.out.println("Введите дробное число");
            gameNum();
        }
//        2
        empty();

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    1) Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
//    необходимо повторно запросить у пользователя ввод данных.

    public static void gameNum() throws ClassCastException{
        br = new BufferedReader(new InputStreamReader(System.in));
        float fl =0f;
        try {
            String f = br.readLine();
            fl = Float.parseFloat(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введено: "+ fl);
    }

 //    2) Разработайте программу, которая выбросит Exception,
//    когда пользователь вводит пустую строку. Пользователю должно
//    показаться сообщение, что пустые строки вводить нельзя.
    public static void empty() throws MyException{
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String f = br.readLine();
            if(f.equals("")){
                throw new MyException("Пустая строка");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyException extends RuntimeException{

        public MyException(String s) {
            super(s);
        }
    }
}

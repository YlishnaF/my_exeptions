package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args)  {
    }

//    Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    public static void calculateDiv(int a, int b){
        if(b==0){
            throw new ArithmeticException("На ноль мы не делим!");
        }
        System.out.println(a/b);

    }

    public static int massElement(int [] a, int b){
        if(a.length-1<b){
            throw new IndexOutOfBoundsException("Запрашивается элемент за пределами длины массива");
        }
        return a[b];
    }

    // Проверяемое исключение
    public static BufferedReader createReader (String name) throws FileNotFoundException {
       return new BufferedReader(new FileReader(name));
    }
//    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//    и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//    Если длины массивов не равны, необходимо как-то оповестить пользователя.
    
    public static int [] resultMass(int[] a, int [] b) throws MyException {
        if(a.length!=b.length){
            throw new MyException("Разные длины массивов, нельзя найти разницу элементов");
        }
        int [] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i]-b[i];            
        }
        return c;
    }
    
    static class MyException extends RuntimeException{

        public MyException(String s) {
            super(s);
        }
    }


    
}

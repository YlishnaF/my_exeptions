package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ThirdLesion {

    public static void main(String[] args) {
        System.out.println("Введите через пробел данные(ФИО, др, номер телефонаа, пол) в следующем формате: Фамилия Имя Отчество 10.10.2020 7449382432 f");
        String[] mData = printData();
        if(mData.length!=6){
            throw new Main.MyException("Введенное количество слов не совпадает с ожидаемым, попробуйте ввести еще раз");
        }
        String f = mData[0];
        String n = mData[1];
        String o = mData[2];
        if(!mData[3].matches("[0-9]{2}.[0-9]{2}.[0-9]{4}")){
            throw new Main.MyException("Номер телефона введен неверно");
        }
        if(!mData[4].matches("\\d+")){
            throw new Main.MyException("Номер телефона введен неверно");
        }
        Long tel = Long.parseLong(mData[4]);
        if(!mData[5].matches("f|m")){
            throw new Main.MyException("Номер телефона введен неверно");
        }
        try {
            String file = mData[0]+".txt";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(f + " " + n+ " " + o+ " " + mData[3]+ " " +tel+mData[5]);
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] printData(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data =null;
        try {
            data = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert data != null;
        String[] mData = data.split(" ");
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mData;
    }
}

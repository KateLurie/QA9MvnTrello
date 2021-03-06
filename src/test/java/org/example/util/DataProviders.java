package org.example.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> loginPositive() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/loginPositive.data")));

        List<Object[]> userData = new ArrayList<>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> loginNegative2() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/loginNegative.data")));

        List<Object[]> userData = new ArrayList<>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> newListCreating() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/newListCreating.data")));

        List<Object[]> userData = new ArrayList<>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }


    @DataProvider
    public static Iterator<Object[]> dataProviderSecond() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"raspopova12@mail.ru", "worldisbeautiful123", "Boards"});
        data.add(new Object[]{"raspopova12@mail.ru", "worldisbeautiful123","BoardsYYY"});
        data.add(new Object[]{"raspopova12@mail.ru", "raspopova12222","Boards"});

        return data.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataProviderThird() {
        List<Object[]> data = new ArrayList();

        for (int i = 0; i < 2; ++i) {
            data.add(new Object[]{this.generateRandomName(), this.generateRandomPassword()});
        }

        return data.iterator();
    }


    private Object generateRandomName() {
        return "demo" + (new Random()).nextInt() + "@gmail.com";
    }

    private Object generateRandomPassword() {

        return "pass" + (new Random()).nextInt();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderThird2() {
        List<Object[]> data = new ArrayList();

        for (int i = 0; i < 2; ++i) {
            data.add(new Object[]{this.generateRandomName2(),this.generateRandomPassword2()});
        }

        return data.iterator();
    }

    private Object generateRandomPassword2() {

       // String pass = "Pass" + (new Random()).nextInt((10)+5);
        ArrayList<Character> charsGenerated = new ArrayList<>();

        String password="";
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ?/.,";
        for (int i = 0;  i<=9 ; i++){

            Random rnd = new Random();
            char ch = alphabet.charAt(rnd.nextInt(alphabet.length()));

            if (!charsGenerated.contains(ch)) {
                charsGenerated.add(ch);

            } else {
                i--;
            }
        }
        for(Character chr: charsGenerated)
        {
            password = password+chr;
        }
        System.out.println(password);
        return password;
    }


    private Object generateRandomName2() {
        ArrayList<Character> charsGenerated = new ArrayList<>();

        String email="";
            String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ?/.,";
        for (int i = 0;  i<=11 ; i++){

            Random rnd = new Random();
            char ch = alphabet.charAt(rnd.nextInt(alphabet.length()));

        if (!charsGenerated.contains(ch)) {
            charsGenerated.add(ch);

        } else {
            i--;
        }
        }
        for(Character chr: charsGenerated)
        {
            email = email+chr;
        }
        System.out.println(email);
         return email;
    }
}



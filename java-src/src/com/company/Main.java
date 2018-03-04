package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            String line;
            Process p = Runtime.getRuntime().exec("ps -e");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }

        try (FileWriter file = new FileWriter("hello.txt")) {
            String sb = "Somethingelse";
            file.write(sb);
        }


	    // write your code here
        Scanner sn = new Scanner(System.in);
        System.out.println("Give me a size ");
        int n = sn.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (true){
            System.out.println("Give me a number ");
            int in = sn.nextInt();
            list.add(in);
        }
    }
}

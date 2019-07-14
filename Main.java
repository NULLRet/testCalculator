package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = new String();
        while (true){
            System.out.println("Input math expression(to end the program, enter: exit)");
            input = in.nextLine();
            if(input.equalsIgnoreCase("exit"))
                break;
            StringCals k = new StringCals(input);
            input = k.toCalculate();
            if(!k.Error())
                System.out.println(input);
            else System.out.println("Invalid expression");
        }
    }
}

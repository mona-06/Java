package com.DAY2.HW.H1;

import java.util.Scanner;

public class WelcomeMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // create Scanner object

        System.out.print("Please enter your name: ");
        String name = sc.nextLine();          // read user input

        System.out.println("Welcome " + name + "!");
    }
}


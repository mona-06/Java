package com.DAY1.HW;

import java.util.Scanner;
class Calculator {


    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter first number: ");
        double n1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double result = 0;

        if (op == '+')
            result = calc.add(n1, n2);
        else if (op == '-')
            result = calc.subtract(n1, n2);
        else if (op == '*')
            result = calc.multiply(n1, n2);
        else if (op == '/')
            result = calc.divide(n1, n2);
        else
            System.out.println("Invalid operator!");

        System.out.println("Result: " + result);
        sc.close();
    }
}

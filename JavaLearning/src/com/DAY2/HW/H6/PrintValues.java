package com.DAY2.HW.H6;

public class PrintValues {
    public static void main(String[] args) {
        String[] values = {"Mumbai", "Bangalore"};

        if (values.length == 0) {
            System.out.println("No values");
        } else {
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i]);
                if (i < values.length - 1)
                    System.out.print(",");
            }
        }
    }

}

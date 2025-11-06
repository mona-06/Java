package com.DAY7.CW.Function;

import java.util.function.Function;


/*
Interface Function{
    public <Output> apply(<Input>);
}
 */


public class FunctionDemo {
    public static void main(String[] args) {
        Function<String,Integer> f=temp->temp.length();
        System.out.println(f.apply("Good Morning"));
    }
}


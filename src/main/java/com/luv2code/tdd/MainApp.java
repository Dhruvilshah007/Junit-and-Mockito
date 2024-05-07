package com.luv2code.tdd;

public class MainApp {

    //WAP to print first 100 FizzBuzz Number, staring from 1 to 100, as per below conditions

    //    If number is divisible by 3,print Fizz
    //    If number is divisible by 5,print Buzz
    //    If number is divisible by 3 and 5,print FizzBuzz
    //    If number is not divisible by 3 or 5,then print the number


    public static void main(String[] args) {

        for(int i=1;i<=100;i++){
//            System.out.println(i+"," +FizzBuzz.compute(i));
            System.out.println(FizzBuzz.compute(i));
        }
    }
}

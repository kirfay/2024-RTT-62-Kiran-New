package org.example;

public class SBA1Practice {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // part 1 - create a for loop to print each character of the string s on its own line
        //use old style for loop
        for(int i= 0; i < s.length(); i++){
            System.out.println(s.charAt(i));
        }
        /*
        A
        B
        C
        D
        E
        F
        G
        H
        I
        J
        K
        L
        M
        ---

         */

        // part 2
        // GIven the following Strings convert them to integer values Integer.valueof();
        String ten = "10";
        String hundred = "100";
        System.out.println(Integer.valueOf(ten));
        System.out.println(Integer.valueOf(hundred));

        // part 3
        // given an integer array find the sum of all the integers in the array
        int[] array = {2, 4, 5, 6, 7, 8, 10};

        // part 4
        // given the array of string convert them to numbers and print the sum
        String[] nums = {"2", "4", "5", "6", "7", "8", "10"}; //loop over these string elements and convert to sum
    }
}

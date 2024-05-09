package org.example;

public class SBA1Practice {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // part 1 - create a for loop to print each character of the string s on its own line
        //use old style for loop
        for(int pos= 0; pos < s.length(); pos++){
            System.out.println(s.charAt(pos));
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

        int ten1 = Integer.valueOf(ten);
        int hun= Integer.valueOf(hundred);



        // part 3
        // given an integer array find the sum of all the integers in the array
        int[] array = {2, 4, 5, 6, 7, 8, 10};
        int sum = 0;
        for (int pos = 0; pos < array.length ; pos++) {
            sum = sum + array[pos];
        }
        System.out.println(sum);

        // part 4
        // given the array of string convert them to numbers and print the sum
        String[] nums = {"2", "4", "5", "6", "7", "8", "10"}; //loop over these string elements and convert to sum
        int sum1 = 0;
        for (String string : nums) {
            int value = Integer.valueOf(string);
            sum1 = sum1 + value;
        }
        System.out.println(sum1);
    }
}

package org.example.PA_303_2_1;

public class JavaBasics {
    //Write a program that declares two integer variables,
    // assigns an integer to each, and adds them together.
    // Assign the sum to a variable. Print out the result.
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        System.out.println("The sum of " + sum);


        //Write a program that declares two double variables,
        // assigns a number to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        double d1 = 2;
        double d2 = 3;
        double dsum = d1 + d2;
        System.out.println("The sum of " + dsum);

        //Write a program that declares an integer variable and a double variable,
        // assigns numbers to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        // What variable type must the sum be?


        int t = 1;
        double j = 6;
        double sum1 = t + j;
        System.out.println("The sum of " + t + "and" + j + "is:" + sum);

        //Write a program that declares two integer variables,assigns an integer to each,
        // and divides the larger number by the smaller number.
        // Assign the result to a variable. Print out the result.

        int k = 2;
        int l = 4;
        double div = (double)l / (double)k;
        System.out.println(div);

        // Now change the larger number to a decimal. What happens? What corrections are needed?
        //when the decimal point is used
//When you convert double to int, the precision of the value is lost.
// For example, when you convert 4.8657 (double) to int, the int value will be 4. Primitive int does not store decimal numbers, so you will lose 0.8657.

        //Write a program that declares two double variables, assigns a number to each, and
        // divides the larger by the smaller number. Assign the result to a variable. Print out the result.
        // Now, cast the result to an integer. Print out the result again.

        int o = 7;
        int p = 4;
        div = (double)o / (double)p;
        System.out.println("div before casting to integer: " + div);
        int castedDiv = (int) div;
        System.out.println("Casted div to an integer: " + castedDiv);

        //Write a program that declares two integer variables, x and y,
        // and assigns the number 5 to x and the number 6 to y.
        // Declare a variable q and assign y/x to it and print q.
        // Now, cast y to a double and assign it to q. Print q again

        int x = 5;
        int y = 6;
        int q = y / x;
        System.out.println("value of q (int): " + q);
        q = (int) ((double) y);
        System.out.println("value of q after casting y to double: " + q);
        //Write a program that declares a named constant and uses it in a calculation. Print the result.




        // Create two more variables called subtotal and totalSale and complete an “order” for three items of the first product,
        // four items of the second product, and two items of the third product.
        // Add them all together to calculate the subtotal.
        // Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale amount.
        // Be sure to format the results to two decimal places.

        //Write a program where you create three variables that represent products at a cafe.
        // The products could be beverages like coffee, cappuccino, espresso, green tea, etc.
        // Assign prices to each product.
        double coffee = 2.50;
        double cappuccino = 3.50;
        double espresso = 4.50;

        double subtotal = (coffee * 3) + (cappuccino * 4) + (espresso * 2);
        double totalSale = subtotal + salesTaxAmount;




    }
}

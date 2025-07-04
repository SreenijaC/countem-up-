/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

public class App {
    public static void main(String[] args) {
        GroceryCounter counter = new GroceryCounter();

        System.out.println("Initial: " + counter.total()); // $0.00

        counter.tens(); // +$10.00
        counter.tens(); // +$10.00
        counter.tenths(); // +$0.10
        counter.hundredths(); // +$0.01

        System.out.println("After increments: " + counter.total()); // $20.11
        System.out.println("Overflows: " + counter.overflows()); // 0
        System.out.println();

        for (int i = 0; i < 35; i++) {
            counter.ones(); // ex: +$1.00 x 35 = $35.00
        }

        System.out.println("After adding $35: " + counter.total());
        System.out.println("Overflows: " + counter.overflows());
        System.out.println();

        for (int i = 0; i < 100; i++) {
            counter.hundredths(); // ex: +$0.01 x 100 = $1.00
        }

        System.out.println("After 100 x $0.01: " + counter.total());
        System.out.println("Overflows: " + counter.overflows());
        System.out.println();

        counter.clear();
        System.out.println("After clear: " + counter.total()); // $0.00
        System.out.println("Overflows: " + counter.overflows()); // 0

        System.out.println();

        for (int i = 0; i < 9; ++i) { // reaching the max value first - 9999
            counter.tens();
            counter.ones();
            counter.tenths();
            counter.hundredths();
        }

        System.out.println("Current total/counter: " + counter.total());
        System.out.println("Overflows (before exceeding the max value): " + counter.overflows()); // 0
        System.out.println();

        // overflowing by exceeding the max: 9999 + 1000 = 10999 % 10000 = 999
        counter.tens();
        System.out.println("Total after overflow: " + counter.total());
        System.out.println("Overflows (after exceeding the max value): " + counter.overflows()); // 1

        System.out.println();
        counter.clear();
        System.out.println("After clear counter: " + counter.total());
        counter.decrementTens(); // 0 - 1000 = -1000 -> (10000-1000)%10000 = 9000 = $90.00
        System.out.println("After underflow: " + counter.total());
    }
}

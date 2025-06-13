package org.example;

public class GroceryCounter {

    private int count; // stores counter value (0000 to 9999 default)
    private int overflowCount; // tracks num of overflows
    private int maxValue; // max allowed value for counter

    // Default constructor start at 0000, max is 9999
    public GroceryCounter() {
        this(0, 9999);
    }

    // sets the counter to a custom start value,
    public GroceryCounter(int startValue) {
        this(startValue, 9999);
    }

    // Constructor sets the counter custom start and max value
    public GroceryCounter(int startValue, int maxValue) {
        if (maxValue <= 0) {
            this.maxValue = 9999;
        } else {
            this.maxValue = maxValue;
        }

        if (startValue >= 0 && startValue <= this.maxValue) {
            this.count = startValue;
        } else {
            this.count = 0;
        }

        this.overflowCount = 0;
    }

    //  Add $10.00 to the counter by increasing the tens digit
    public void tens() {
        add(1000);
    }

    // increase $1.00 (ones place)
    public void ones() {
        add(100);
    }

    // increase $0.10 (tenths place)
    public void tenths() {
        add(10);
    }

    // increase $0.01 (hundredths place)
    public void hundredths() {
        add(1);
    }

    //Decreases the counter by $10.00
    public void decrementTens() {
        subtract(1000);
    }

    // Decrease by $1.00 (which is 100 cents)
    public void decrementOnes() {
        subtract(100);
    }

    // Decrease $0.10
    public void decrementTenths() {
        subtract(10);
    }

    // Decrease $0.01
    public void decrementHundredths() {
        subtract(1);
    }

    // increase by any custom value
    public void increment(int amount) {
        add(amount);
    }

    // format total value in $
    public String total() {
        int dollars = count / 100;
        int cents = count % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    // return no. of times overflow done
    public int overflows() {
        return overflowCount;
    }

    // reset counter and overflow count
    public void clear() {
        count = 0;
        overflowCount = 0;
    }

    // handles overflow logic
    private void add(int value) {
        count += value;
        if (count > maxValue) {
            overflowCount++;
            // Wrap count back to 0 after maxvalue passed 
            count = count % (maxValue + 1);
        }
    }

    // handles underflow logic
    private void subtract(int value) {
        count -= value;
        if (count < 0) {
            overflowCount++;
            // Wrap count from below zero to maxvalue 
            count = (maxValue + 1 + count) % (maxValue + 1);
        }
    }
}

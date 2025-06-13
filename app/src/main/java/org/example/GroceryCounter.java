package org.example;

public class GroceryCounter {

    private int count; // stores counter value (0000 to 9999 by default)
    private int overflowCount; // tracks number of overflows
    private int maxValue; // maximum allowed value for counter

    // Default constructor: starts at 0000, max is 9999
    public GroceryCounter() {
        this(0, 9999);
    }

    // Constructor with custom starting value
    public GroceryCounter(int startValue) {
        this(startValue, 9999);
    }

    // Constructor with custom starting value and max value
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

    // Increment $10.00 (tens place)
    public void tens() {
        add(1000);
    }

    // Increment $1.00 (ones place)
    public void ones() {
        add(100);
    }

    // Increment $0.10 (tenths place)
    public void tenths() {
        add(10);
    }

    // Increment $0.01 (hundredths place)
    public void hundredths() {
        add(1);
    }

    // Decrement $10.00
    public void decrementTens() {
        subtract(1000);
    }

    // Decrement $1.00
    public void decrementOnes() {
        subtract(100);
    }

    // Decrement $0.10
    public void decrementTenths() {
        subtract(10);
    }

    // Decrement $0.01
    public void decrementHundredths() {
        subtract(1);
    }

    // Increment by any custom value
    public void increment(int amount) {
        add(amount);
    }

    // formatted total value in $
    public String total() {
        int dollars = count / 100;
        int cents = count % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    // Return no. of times overflow done
    public int overflows() {
        return overflowCount;
    }

    // Reset counter and overflow count
    public void clear() {
        count = 0;
        overflowCount = 0;
    }

    // handles overflow logic
    private void add(int value) {
        count += value;
        if (count > maxValue) {
            overflowCount++;
            count = count % (maxValue + 1);
        }
    }

    // handles underflow logic
    private void subtract(int value) {
        count -= value;
        if (count < 0) {
            overflowCount++;
            count = (maxValue + 1 + count) % (maxValue + 1);
        }
    }
}

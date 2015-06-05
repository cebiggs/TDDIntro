package com.thoughtworks.factorial;

public class Factorial {
    public Integer compute(int i) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if(i == 0 || i == 1) {
            return 1;
        }
        return i * compute(i - 1);
    }
}

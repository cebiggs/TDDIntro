package com.thoughtworks.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i == 0 || i == 1) {
            return 1;
        }
        return i * compute(i - 1);
    }
}

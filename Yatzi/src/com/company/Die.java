package com.company;

class Die {

    private int value = 0;

    void setValue(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    int roll() {
        value = (int) (Math.random() * 6 + 1);
        return value;
    }
}
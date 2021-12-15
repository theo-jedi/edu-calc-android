package com.theost.calcapp;

import androidx.annotation.NonNull;

enum TypeNum {
    BRACKET_LEFT("("), BRACKET_RIGHT(")"), NUM_0("0"), NUM_1("1"), NUM_2("2"), NUM_3("3"), NUM_4("4"), NUM_5("5"), NUM_6("6"), NUM_7("7"), NUM_8("8"), NUM_9("9");

    private final String equationValue;

    TypeNum(String s) {
        equationValue = s;
    }

    @NonNull
    public String toString() {
        return this.equationValue;
    }
}
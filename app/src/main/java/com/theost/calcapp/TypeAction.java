package com.theost.calcapp;

import androidx.annotation.NonNull;

enum TypeAction {
    DIVIDE("/"), MULTIPLE("*"), MINUS("-"), PLUS("+"), DOT(".");

    private final String equationValue;

    TypeAction(String s) {
        equationValue = s;
    }

    @NonNull
    public String toString() {
        return this.equationValue;
    }
}
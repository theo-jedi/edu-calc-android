package com.theost.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.theost.calcapp.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Object> equationList = new ArrayList<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.button0.setOnClickListener(view -> addNum(TypeNum.NUM_0));
        binding.button1.setOnClickListener(view -> addNum(TypeNum.NUM_1));
        binding.button2.setOnClickListener(view -> addNum(TypeNum.NUM_2));
        binding.button3.setOnClickListener(view -> addNum(TypeNum.NUM_3));
        binding.button4.setOnClickListener(view -> addNum(TypeNum.NUM_4));
        binding.button5.setOnClickListener(view -> addNum(TypeNum.NUM_5));
        binding.button6.setOnClickListener(view -> addNum(TypeNum.NUM_6));
        binding.button7.setOnClickListener(view -> addNum(TypeNum.NUM_7));
        binding.button8.setOnClickListener(view -> addNum(TypeNum.NUM_8));
        binding.button9.setOnClickListener(view -> addNum(TypeNum.NUM_9));
        binding.buttonBracketLeft.setOnClickListener(view -> addNum(TypeNum.BRACKET_LEFT));
        binding.buttonBracketRight.setOnClickListener(view -> addNum(TypeNum.BRACKET_RIGHT));

        binding.buttonDivide.setOnClickListener(view -> addAction(TypeAction.DIVIDE));
        binding.buttonMultiple.setOnClickListener(view -> addAction(TypeAction.MULTIPLE));
        binding.buttonMinus.setOnClickListener(view -> addAction(TypeAction.MINUS));
        binding.buttonPlus.setOnClickListener(view -> addAction(TypeAction.PLUS));
        binding.buttonDot.setOnClickListener(view -> addAction(TypeAction.DOT));

        binding.buttonAC.setOnClickListener(view -> clearText());
        binding.buttonBack.setOnClickListener(view -> clearLast());

        binding.buttonEquals.setOnClickListener(view -> solveEquation());
    }

    private void clearText() {
        equationList.clear();
        binding.statusView.setText("");
    }

    private void clearLast() {
        if (equationList.size() > 0) {
            equationList.remove(equationList.size() - 1);
            String equation = binding.statusView.getText().toString();
            binding.statusView.setText(equation.substring(0, equation.length() - 2));
        }
    }

    private void solveEquation() {
        double result = new ExpressionBuilder(convertEquation()).build().evaluate();
        binding.resultView.setText(String.valueOf(result));
    }

    private String convertEquation() {
        StringBuilder equation = new StringBuilder();
        for (Object element : equationList) {
            if (element.getClass() == TypeAction.class) {
                equation.append(((TypeAction) element).toString());
            } else if (element.getClass() == TypeNum.class) {
                equation.append(((TypeNum) element).toString());
            }
        }
        return equation.toString();
    }

    private void addAction(TypeAction action) {
        // todo обработка ввода
        equationList.add(action);
    }

    private void addNum(TypeNum action) {
        equationList.add(action);
    }

}
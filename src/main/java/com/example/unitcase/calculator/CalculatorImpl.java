package com.example.unitcase.calculator;

public class CalculatorImpl implements Calculator{

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int substract(int a, int b) {
        return a - b;
    }

    @Override
    public int divide(int a, int b) {
        if (b == 0)
            throw new OperationException("Division by zero forbidden");

        return a / b;
    }
}

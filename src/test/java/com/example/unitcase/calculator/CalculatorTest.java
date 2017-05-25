package com.example.unitcase.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CalculatorTest {

    Calculator calculator = new CalculatorImpl();

    @Test
    public void should_add_two_numbers() {
        int a = 5;
        int b = 6;

        int result = calculator.add(a, b);

        assertThat(result).isEqualTo(11);
    }

    @Test
    public void should_substract_two_numbers() {
        int a = 5;
        int b = 4;

        int result = calculator.substract(a, b);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_divide_two_numbers() {
        int a = 4;
        int b = 2;

        int result = calculator.divide(a, b);

        assertThat(result).isEqualTo(2);
    }

    @Test(expected = OperationException.class)
    public void should_throw_operation_exception_when_divide_by_zero() {
        int a = 4;
        int b = 0;

        calculator.divide(a, b);
    }
}







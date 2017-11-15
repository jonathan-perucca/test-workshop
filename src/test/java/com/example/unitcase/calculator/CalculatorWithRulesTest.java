package com.example.unitcase.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorWithRulesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void should_throw_operation_exception_when_divide_by_zero() {
        int a = 4;
        int b = 0;
        expectedException.expect(OperationException.class);
        expectedException.expectMessage("Division by zero forbidden");

        calculator.divide(a, b);
    }
}

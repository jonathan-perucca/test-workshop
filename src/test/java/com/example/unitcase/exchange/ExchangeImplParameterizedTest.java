package com.example.unitcase.exchange;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static com.example.unitcase.exchange.State.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ExchangeImplParameterizedTest {

    @Parameters(name = "{0} transition to {1}, Exception : {2}")
    public static Collection<Object[]> data() {
        return asList(new Object[][] {
                {PENDING, READY, false},
                {READY, CONFLICTED, false},
                {READY, FINALIZED, false},
                {READY, PENDING, true},
                {CONFLICTED, READY, true},
                {CONFLICTED, FINALIZED, true},
                {CONFLICTED, PENDING, true},
                {FINALIZED, PENDING, true},
                {FINALIZED, READY, true},
                {FINALIZED, CONFLICTED, true},

        });
    }

    @Parameter(0)
    public State initialState;
    @Parameter(1)
    public State destinationState;
    @Parameter(2)
    public boolean shouldThrowException;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    Exchange exchange;

    @Test
    public void should_make_transition() {
        exchange = new ExchangeImpl(initialState);
        if(shouldThrowException) {
            exception.expect(ImpossibleTransitionException.class);
        }

        exchange.moveTo(destinationState);

        assertThat(exchange.getState()).isEqualTo(destinationState);
    }
}

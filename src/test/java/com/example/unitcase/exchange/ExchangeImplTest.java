package com.example.unitcase.exchange;

import org.junit.Test;

import static com.example.unitcase.exchange.State.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeImplTest {

    Exchange exchange;

    @Test
    public void should_move_from_pending_to_ready() {
        exchange = new ExchangeImpl(PENDING);

        exchange.moveTo(READY);

        assertThat(exchange.getState()).isEqualTo(READY);
    }

    @Test
    public void should_move_from_ready_to_conflicted() {
        exchange = new ExchangeImpl(READY);

        exchange.moveTo(CONFLICTED);

        assertThat(exchange.getState()).isEqualTo(CONFLICTED);
    }

    @Test
    public void should_move_from_ready_to_finalized() {
        exchange = new ExchangeImpl(READY);

        exchange.moveTo(FINALIZED);

        assertThat(exchange.getState()).isEqualTo(FINALIZED);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void should_move_from_ready_to_pending() {
        exchange = new ExchangeImpl(READY);

        exchange.moveTo(PENDING);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void should_move_from_conflicted_to_ready() {
        exchange = new ExchangeImpl(CONFLICTED);

        exchange.moveTo(READY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void should_move_from_conflicted_to_finalized() {
        exchange = new ExchangeImpl(CONFLICTED);

        exchange.moveTo(FINALIZED);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void should_move_from_conflicted_to_pending() {
        exchange = new ExchangeImpl(CONFLICTED);

        exchange.moveTo(PENDING);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void should_move_from_finalized_to_pending() {
        exchange = new ExchangeImpl(FINALIZED);

        exchange.moveTo(PENDING);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void should_move_from_finalized_to_ready() {
        exchange = new ExchangeImpl(FINALIZED);

        exchange.moveTo(READY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void should_move_from_finalized_to_conflicted() {
        exchange = new ExchangeImpl(FINALIZED);

        exchange.moveTo(CONFLICTED);
    }
}
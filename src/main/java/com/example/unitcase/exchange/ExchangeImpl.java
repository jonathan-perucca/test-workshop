package com.example.unitcase.exchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.unitcase.exchange.State.*;
import static java.util.Arrays.asList;

public class ExchangeImpl implements Exchange {

    private State state;

    private Map<State, List<State>> transitions;

    public ExchangeImpl(State state) {
        this.state = state;
        initializeTransitions();
    }

    private void initializeTransitions() {
        transitions = new HashMap<>();
        transitions.put(PENDING, asList(READY));
        transitions.put(READY, asList(CONFLICTED, FINALIZED));
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void moveTo(State newState) {
        List<State> states = transitions.get(this.state);
        if (states == null || !states.contains(newState))
            throw new ImpossibleTransitionException();

        this.state = newState;
    }
}

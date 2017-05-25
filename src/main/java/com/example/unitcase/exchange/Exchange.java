package com.example.unitcase.exchange;

public interface Exchange {

    State getState();

    void moveTo(State state);
}

package com.game.controls;

public interface Movement {

    void setNext(Movement next);

    boolean action();

    boolean pass(int key);
}

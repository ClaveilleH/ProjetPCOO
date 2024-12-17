package com.game.controls;

import com.badlogic.gdx.Input;

import java.util.ArrayList;

public class ControlsManager {
    private static ControlsManager instance;

    private Movement movementUp;
    private Movement movementDown;
    private Movement movementLeft;
    private Movement movementRight;


    private ControlsManager() {
        this.movementUp = new MovementUp(Input.Keys.UP);
    }


    public static ControlsManager getInstance() {
        if (instance == null) {
            instance = new ControlsManager();
        }
        return instance;
    }

}

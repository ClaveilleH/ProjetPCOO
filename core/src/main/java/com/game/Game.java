package com.game;

import com.game.controls.ControlsManager;

public class Game {
    //stock toutes les classes du jeu
    private static Game instance;
    private PlayerInputProcessor playerInputProcessor;
    private ControlsManager controlsManager;


    private Game() {

    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

}

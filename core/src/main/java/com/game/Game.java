package com.game;

import com.badlogic.gdx.Gdx;
import com.game.controls.ControlsManager;

public class Game {
    //stock toutes les classes du jeu
    private static Game instance;
    public PlayerInputProcessor playerInputProcessor;
    public ControlsManager controlsManager;


    private Game() {
        this.controlsManager = ControlsManager.getInstance();
//        this.playerInputProcessor = new PlayerInputProcessor();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

}

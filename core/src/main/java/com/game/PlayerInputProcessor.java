package com.game;

import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;

public class PlayerInputProcessor implements InputProcessor {
    private static PlayerInputProcessor instance;

    private Player player;
    private ArrayList<Integer> keysPressed;

    private PlayerInputProcessor(Player player) {
        this.player = player;
        this.keysPressed = new ArrayList<>();
//        System.out.println("-------->"+this.keysPressed);
    }

    public static PlayerInputProcessor getInstance(Player player) {
        if (instance == null) {
            instance = new PlayerInputProcessor(player);
        }
        return instance;
    }

    public ArrayList<Integer> getKeysPressed() {
        return this.keysPressed;
    }

    public static PlayerInputProcessor getInstance() {
        if (instance == null) {
            instance = new PlayerInputProcessor(Player.getPlayer());
        }
        return instance;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 111) {
            System.out.println("ESC pressed");
            System.exit(0);
        }
        if ( ! this.keysPressed.contains(keycode)) {
            this.keysPressed.add(keycode);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
//        System.out.println(this.keysPressed + Integer.toString(keycode));
         if (this.keysPressed.contains(keycode)) {
             this.keysPressed.remove(this.keysPressed.indexOf(keycode));
         }
//        this.keysPressed.remove(keycode);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

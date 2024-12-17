package com.game;

import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;

public class PlayerInputProcessor implements InputProcessor {
    private Player player;
    private ArrayList<Integer> keysPressed;

    public PlayerInputProcessor(Player player) {
        this.player = player;
        this.keysPressed = new ArrayList<>();

    }

    @Override
    public boolean keyDown(int keycode) {
        if ( ! this.keysPressed.contains(keycode)) {
            this.keysPressed.add(keycode);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println(this.keysPressed + Integer.toString(keycode));
        if (this.keysPressed.contains(keycode)) {
            this.keysPressed.remove(this.keysPressed.indexOf(keycode));
        }
        return false;
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

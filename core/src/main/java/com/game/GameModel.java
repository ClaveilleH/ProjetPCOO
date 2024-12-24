package com.game;

import com.badlogic.gdx.Gdx;

public class GameModel {
    private static GameModel game;
    String name;
    private int playerSpeed;

    private GameModel(){
        this.name = "";
        this.playerSpeed = 1;
    }

    public static GameModel getGame(){
        if(game == null){
            game = new GameModel();
        }
        return game;
    }

    public void input() {
//        float speed = .25f;
//
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            bucketSprite.translateX(speed); // Move the bucket right
//        }
        System.out.println(Gdx.input.getX());
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }
}

package com.game;

import com.badlogic.gdx.Gdx;

public class GameModel {
    private static GameModel game;
    String name;

    private GameModel(){
        this.name = "";
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
}

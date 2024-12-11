package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;


public class Main extends Game {
//    Texture img;
    TiledMap tiledMap;
    int x;
    int y;
    View view;
    Player player;


    @Override
    public void create() {
        tiledMap = loadMap();
        System.out.println("Map loaded");

        this.view = new View(tiledMap);
        this.player = Player.getPlayer();

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.player.setX((int) (width / 2));
        this.player.setY((int) (height / 2));



        System.out.println("w = " + width + ", h = " + height);
//        System.out.println("Camera update");

//        mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        System.out.println("TiledMap loaded");

//        mapRenderer.setView(camera);

    }

    public TiledMap loadMap() {
        return new TmxMapLoader().load("map/map1.tmx");
    }

    @Override
    public void render() {
        this.view.render();

    }
}

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
    OrthographicCamera camera;
    TiledMapRenderer mapRenderer;
    int x;
    int y;


    @Override
    public void create() {
        this.x = 0;
        this.y = 0;

        //setScreen(new FirstScreen());
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        System.out.println("w = " + w + ", h = " + h);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        System.out.println("Camera update");

        tiledMap = loadMap();
        System.out.println("Map loaded");
        mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        System.out.println("TiledMap loaded");

        mapRenderer.setView(camera);
    }

    public TiledMap loadMap() {
        return new TmxMapLoader().load("map/map1.tmx");
    }

    @Override
    public void render() {
        draw();

    }


    public void draw() {
        camera.position.set(this.x, this.y, 0);
        camera.update();
        this.x += 1;
        this.y += 1;
        mapRenderer.setView(camera);
        System.out.println("Map rendered"+ this.x);
        mapRenderer.render();
    }
}

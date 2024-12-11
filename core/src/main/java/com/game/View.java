package com.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

import java.util.Observable;
import java.util.Observer;

public class View {
    Player player;
    OrthographicCamera camera;
    TiledMapRenderer mapRenderer;


    public View(TiledMap tiledMap) {
        this.camera = new OrthographicCamera();
//        camera.update(); // pas sur de le garde ca sera vait au premier update
        this.mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        this.player = Player.getPlayer();

    }

    public void render() {
        this.camera.position.set(this.player.getX(), this.player.getY(), 0);
        this.camera.update();
        this.mapRenderer.setView(this.camera);
        this.mapRenderer.render();

        System.out.println("Map rendered"+ this.player.getX() +" "+ this.player.getY());
    }

}

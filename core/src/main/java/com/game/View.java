package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.game.controls.ControlsManager;

public class    View {
    private Player player;
    private OrthographicCamera camera;
    private TiledMapRenderer mapRenderer;
    private SpriteBatch batch;
    private ControlsManager controlsManager;


    public View(TiledMap tiledMap) {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, w ,h);
        System.out.println("w = " + w + ", h = " + h);
//        camera.update(); // pas sur de le garde ca sera vait au premier update
        this.mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        this.player = Player.getPlayer();
        this.batch = new SpriteBatch();
        this.controlsManager = ControlsManager.getInstance();

    }

    public void render(float delta) {
        this.camera.position.set(this.player.getPosX(), this.player.getPosY(), 0);

        this.camera.update();
        this.controlsManager.update();
//        this.player.update();

        this.mapRenderer.setView(this.camera);
        this.mapRenderer.render();


        this.batch.begin();
        this.player.render(this.batch);

        this.batch.end();

//        System.out.println("Map rendered"+ this.player.getX() +" "+ this.player.getY());
    }

}

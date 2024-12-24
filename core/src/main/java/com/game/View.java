package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.game.controls.ControlsManager;

public class    View {
    private Player player;
    private OrthographicCamera camera;
    private TiledMap tiledMap;
    private TiledMapRenderer mapRenderer;
    private SpriteBatch batch;
    private ControlsManager controlsManager;

    final float scale = 32f;


    public View(TiledMap tiledMap) {
        this.tiledMap = tiledMap;
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, w, h);
        System.out.println("w = " + w + ", h = " + h);
//        camera.update(); // pas sur de le garde ca sera fait au premier update
        this.mapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
//        this.mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        this.player = Player.getPlayer();
        this.batch = new SpriteBatch();
        this.controlsManager = ControlsManager.getInstance();

    }

    public void update(float delta) {
        this.controlsManager.update();
//        this.camera.position.lerp(
//            new Vector3(this.player.getPosX(), this.player.getPosY(), 0),
//            0.1f+2  // Facteur de lissage
//        );

        // Positionne la caméra directement sur le joueur
        float cameraX = this.player.getPosX();
        float cameraY = this.player.getPosY();

        // Limite la position de la caméra pour éviter que le joueur sorte de l'écran
        float mapWidth = tiledMap.getProperties().get("width", Integer.class) * scale;
        float mapHeight = tiledMap.getProperties().get("height", Integer.class) * scale;
        float viewportWidth = Gdx.graphics.getWidth();
        float viewportHeight = Gdx.graphics.getHeight();

        // Empêche la caméra de dépasser les bords de la carte
        cameraX = Math.max(viewportWidth / 2, Math.min(cameraX, mapWidth - viewportWidth / 2));
        cameraY = Math.max(viewportHeight / 2, Math.min(cameraY, mapHeight - viewportHeight / 2));

        // Applique les nouvelles positions à la caméra
        this.camera.position.set(cameraX, cameraY, 0);

        this.camera.update();

        System.out.println(this.player.getPosX() + " " + this.player.getPosY());
        System.out.println("cam : " + this.camera.position.x + " " + this.camera.position.y);

    }

    public void render(float delta) {
//        DebugRenderer.drawGrid(this.camera); // Nécessite une classe utilitaire ou dessine manuellement


        this.controlsManager.update();

//        this.camera.position.set(this.player.getPosX(), this.player.getPosY(), 0);
//        this.camera.position.set(639, , 0);
//        this.camera.position.lerp(
//            new Vector3(this.player.getPosX(), this.player.getPosY(), 0),
//            0.1f  // Facteur de lissage
//        );

//        this.camera.update();
    //    this.player.update();

        this.mapRenderer.setView(this.camera);
        this.mapRenderer.render();
//        this.mapRenderer.

        this.batch.begin();
        this.player.render(this.batch);

        this.batch.end();

//        System.out.println("Map rendered"+ this.player.getX() +" "+ this.player.getY());
    }

}

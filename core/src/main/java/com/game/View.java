package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.game.controls.ControlsManager;

public class    View {
    private Player player;
    private OrthographicCamera camera;
    private TiledMap tiledMap;
    private TiledMapRenderer mapRenderer;
    private SpriteBatch batch;
    private ControlsManager controlsManager;



    public View(TiledMap tiledMap) {
        this.tiledMap = tiledMap;
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        this.camera = new OrthographicCamera();
//        this.camera.setToOrtho(false, mapWidth, mapHeight);
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


        // Positionne la caméra directement sur le joueur
        float playerX = this.player.getPosX();
        float playerY = this.player.getPosY();


        int tileWidth = tiledMap.getProperties().get("tilewidth", Integer.class);
        int tileHeight = tiledMap.getProperties().get("tileheight", Integer.class);

        // Limite la position de la caméra pour éviter que le joueur sorte de l'écran
        float mapWidth = tiledMap.getProperties().get("width", Integer.class) * tileWidth;
        float mapHeight = tiledMap.getProperties().get("height", Integer.class) * tileHeight;
        float viewportWidth = Gdx.graphics.getWidth();
        float viewportHeight = Gdx.graphics.getHeight();

        float centerW = viewportWidth / 2 - this.player.getTextureWidth() / 2;
        float centerH = viewportHeight / 2 - this.player.getTextureHeight() / 2;

        this.player.update(mapWidth, mapHeight);


        // Empêche la caméra de dépasser les bords de la carte
        float cameraX = Math.max(viewportWidth / 2, Math.min(playerX, mapWidth - viewportWidth / 2));
        float cameraY = Math.max(viewportHeight / 2, Math.min(playerY, mapHeight - viewportHeight / 2));


        cameraX = playerX;
        if (playerX < viewportWidth / 2) { // bord gauche
            cameraX = viewportWidth / 2;
            this.player.setSpritePosX(centerW - (cameraX - this.player.getPosX()));
        } else if (playerX > mapWidth - viewportWidth / 2) {
            cameraX = mapWidth - viewportWidth / 2;
            this.player.setSpritePosX(centerW - (cameraX - this.player.getPosX()));
        }

        cameraY = playerY;
        if (playerY < viewportHeight / 2) {
            cameraY = viewportHeight / 2;
            this.player.setSpritePosY(centerH - (cameraY - this.player.getPosY()));
        }else if(playerY > mapHeight - viewportHeight / 2){
            cameraY = mapHeight - viewportHeight / 2;
            this.player.setSpritePosY(centerH - (cameraY - this.player.getPosY()));
        }

        // Applique les nouvelles positions à la caméra
        this.camera.position.set(cameraX, cameraY, 0);
//        this.camera.position.lerp(
//            new Vector3(this.player.getPosX(), this.player.getPosY(), 0),
//            0.1f+2  // Facteur de lissage
//        );
        this.camera.update();

    }

    public void render(float delta) {
        ScreenUtils.clear(1,0,0,1,true);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        //        DebugRenderer.drawGrid(this.camera); // Nécessite une classe utilitaire ou dessine manuellement


//        this.controlsManager.update();

//        this.camera.position.set(this.player.getPosX(), this.player.getPosY(), 0);
//        this.camera.position.set(639, , 0);
//        this.camera.position.lerp(
//            new Vector3(this.player.getPosX(), this.player.getPosY(), 0),
//            0.1f  // Facteur de lissage
//        );

//        this.camera.update();

        this.mapRenderer.setView(this.camera);
        this.mapRenderer.render();
//        this.mapRenderer.

        this.batch.begin();
        this.player.render(this.batch);

        this.batch.end();

//        System.out.println("Map rendered"+ this.player.getX() +" "+ this.player.getY());
    }

}

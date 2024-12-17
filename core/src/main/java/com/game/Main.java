package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;


public class Main extends Game {
//    Texture img;
    TiledMap tiledMap;
    int x;
    int y;
    View view;
    Player player;
    GameModel game;

    @Override
    public void create() {
        tiledMap = loadMap();
        System.out.println("Map loaded");

        this.view = new View(tiledMap);
        this.player = Player.getPlayer();

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.player.setPosX((int) (width / 2));
        this.player.setPosY((int) (height / 2));

        this.game = GameModel.getGame();


        System.out.println("w = " + width + ", h = " + height);
//        System.out.println("Camera update");

//        mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        System.out.println("TiledMap loaded");

//        mapRenderer.setView(camera);

        Gdx.input.setInputProcessor(new PlayerInputProcessor(player));


    }

    public TiledMap loadMap() {
        return new TmxMapLoader().load("map/map1.tmx");
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        this.view.render(delta);

    }


    public void update() {
        System.out.println("update");
    }

    private void input() {
        this.game.input();

        System.out.println("Input pressed");
    }

}

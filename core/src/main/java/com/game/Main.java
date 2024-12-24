package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class Main extends Game {
//    Texture img;
    private TiledMap tiledMap;
    private int x;
    private int y;
    private View view;
    private Player player;
    private GameModel gameModel;
    private PlayerInputProcessor playerInputProcessor;

    private Game game;

    @Override
    public void create() {
        tiledMap = loadMap();
        System.out.println("Map loaded");

        this.view = new View(tiledMap);

        this.player = Player.getPlayer();
//        System.out.println(this.view.);
//        this.game = Game.getI

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        System.out.println("Width: " + width
        + " Height: " + height);

        this.player.setPosX((int) (width / 2));
        this.player.setPosY((int) (height / 2));

//        this.player.setPosX((int) (width - 1));
//        this.player.setPosY((int) (height - 1));


//        this.player.setPosX((int) (150));
//        this.player.setPosY((int) (150));

        this.gameModel = GameModel.getGame();


        System.out.println("w = " + width + ", h = " + height);
//        System.out.println("Camera update");

//        mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        System.out.println("TiledMap loaded");

//        mapRenderer.setView(camera);
        this.playerInputProcessor = PlayerInputProcessor.getInstance(player);
//        Gdx.input.setInputProcessor(new PlayerInputProcessor(player));
        Gdx.input.setInputProcessor(this.playerInputProcessor);


    }

    public TiledMap loadMap() {
        return new TmxMapLoader().load("map/map1.tmx");
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        this.view.update(delta);
        this.view.render(delta);

    }


    public void update() {
        System.out.println("update");
    }

    private void input() {
        this.gameModel.input();

        System.out.println("Input pressed");
    }

}

package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Entity {
    private static Player player;
    private Texture texture;
    private SpriteBatch batch;
    private Animation<TextureRegion> animation;
    float stateTime;

    private static final int FRAME_COLS = 13, FRAME_ROWS = 46;


    private Player(int x, int y) {
        super(x, y);

        this.texture = new Texture(Gdx.files.internal("sprites/Santa.png"));

        TextureRegion[][] temp = TextureRegion.split(this.texture, this.texture.getWidth() / FRAME_COLS, this.texture.getHeight() / FRAME_ROWS);

        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                walkFrames[index++] = temp[i][j];
            }
        }
        // for (int i = 0; i < FRAME_COLS; i++) {
        //     for (int j = 0; j < FRAME_ROWS; j++) {
        //         walkFrames[index++] = temp[i][j];
        //     }
        // }
        this.animation = new Animation<TextureRegion>(0.25f, walkFrames);

        this.batch = new SpriteBatch();
        stateTime = 0f;
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(0, 0);
        }
        return player;
    }

    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = this.animation.getKeyFrame(stateTime, true);
        this.batch.begin();
        this.batch.draw(currentFrame, 50, 50); // Draw current frame at (50, 50)
        this.batch.end();
    }
}

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
    private Animation<TextureRegion> upWalkAnimation;
    private Animation<TextureRegion> downWalkAnimation;
    private Animation<TextureRegion> rightWalkAnimation;
    private Animation<TextureRegion> leftWalkAnimation;
    float stateTime;

    private static final int FRAME_COLS = 13, FRAME_ROWS = 46;
    private static final float FRAME_DURATION = 0.25f;


    private Player(int x, int y) {
        super(x, y);

        this.texture = new Texture(Gdx.files.internal("sprites/SantaShadow.png"));

        TextureRegion[][] temp = TextureRegion.split(this.texture, this.texture.getWidth() / FRAME_COLS, this.texture.getHeight() / FRAME_ROWS);

        int walkNb = 8;

        TextureRegion[] upWalkAnimation = new TextureRegion[walkNb];
        TextureRegion[] downWalkAnimation = new TextureRegion[walkNb];
        TextureRegion[] rightWalkAnimation = new TextureRegion[walkNb];
        TextureRegion[] leftWalkAnimation = new TextureRegion[walkNb];

        int start = 8;
        int index = 0;
        for (int j = 1; j < 9; j++) { //-----------------------------------------------changer 9
            upWalkAnimation[index] = new TextureRegion(temp[start][j]);
            downWalkAnimation[index] = new TextureRegion(temp[start + 1][j]);
            rightWalkAnimation[index] = new TextureRegion(temp[start + 2][j]);
            leftWalkAnimation[index] = new TextureRegion(temp[start + 3][j]);
            index++;
        }
        this.upWalkAnimation = new Animation<TextureRegion>(FRAME_DURATION, upWalkAnimation);
//        this.animation = new Animation<TextureRegion>(0.25f, walkFrames);

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

//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = this.upWalkAnimation.getKeyFrame(stateTime, true);
        this.batch.begin();
        this.batch.draw(currentFrame, 50, 50); // Draw current frame at (50, 50)
        this.batch.end();
    }
}

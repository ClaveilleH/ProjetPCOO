package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Entity {
    private static Player player;
    private final Texture texture;
    private Animation<TextureRegion> currentAnimation;


    private final Animation<TextureRegion> upWalkAnimation;
    private final Animation<TextureRegion> downWalkAnimation;
    private final Animation<TextureRegion> rightWalkAnimation;
    private final Animation<TextureRegion> leftWalkAnimation;
    float stateTime;

    private static final int FRAME_COLS = 13, FRAME_ROWS = 46;
    private static final float FRAME_DURATION = 0.25f;


    private Player(int x, int y) {
        super(x, y);

        this.texture = new Texture(Gdx.files.internal("sprites/SantaShadow.png"));

        TextureRegion[][] temp = TextureRegion.split(this.texture, this.texture.getWidth() / FRAME_COLS, this.texture.getHeight() / FRAME_ROWS);

        int walkNb = 8;

        TextureRegion[] temp_upWalkAnimation = new TextureRegion[walkNb];
        TextureRegion[] temp_downWalkAnimation = new TextureRegion[walkNb];
        TextureRegion[] temp_rightWalkAnimation = new TextureRegion[walkNb];
        TextureRegion[] temp_leftWalkAnimation = new TextureRegion[walkNb];

        int start = 8;
        int index = 0;
        for (int j = 1; j < 9; j++) { //-----------------------------------------------changer 9
            temp_upWalkAnimation[index] = new TextureRegion(temp[start][j]);
            temp_leftWalkAnimation[index] = new TextureRegion(temp[start + 1][j]);
            temp_downWalkAnimation[index] = new TextureRegion(temp[start + 2][j]);
            temp_rightWalkAnimation[index] = new TextureRegion(temp[start + 3][j]);
            index++;
        }
        this.upWalkAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp_upWalkAnimation);
        this.downWalkAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp_downWalkAnimation);
        this.rightWalkAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp_rightWalkAnimation);
        this.leftWalkAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp_leftWalkAnimation);
        this.currentAnimation = this.downWalkAnimation;
//        this.animation = new Animation<TextureRegion>(0.25f, walkFrames);

        stateTime = 0f;
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(0, 0);
        }
        return player;
    }

    public void render(SpriteBatch batch) {

//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = this.currentAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, super.getPosX(), super.getPosY()); // Draw current frame at (50, 50)
    }

    public TextureRegion getCurrentFrame(float batch) {
        return this.currentAnimation.getKeyFrame(batch, true);
    }

    public void setCurrentAnimation(Animation<TextureRegion> currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    public Animation<TextureRegion> getUpWalkAnimation() {
        return upWalkAnimation;
    }

    public Animation<TextureRegion> getDownWalkAnimation() {
        return downWalkAnimation;
    }

    public Animation<TextureRegion> getRightWalkAnimation() {
        return rightWalkAnimation;
    }

    public Animation<TextureRegion> getLeftWalkAnimation() {
        return leftWalkAnimation;
    }
}

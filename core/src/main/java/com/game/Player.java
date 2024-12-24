package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Entity {
    private static Player player;
    private Sprite sprite;

    private final Texture texture;
    private final float textureWidth;
    private final float textureHeight;
    private Animation<TextureRegion> currentAnimation;
    private Animation<TextureRegion> currentStandingAnimation;


    private final Animation<TextureRegion> upWalkAnimation;
    private final Animation<TextureRegion> downWalkAnimation;
    private final Animation<TextureRegion> rightWalkAnimation;
    private final Animation<TextureRegion> leftWalkAnimation;
    private final Animation<TextureRegion> standingUpAnimation;
    private final Animation<TextureRegion> standingDownAnimation;
    private final Animation<TextureRegion> standingRightAnimation;
    private final Animation<TextureRegion> standingLeftAnimation;


    float stateTime;
    private boolean walking;

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

        this.standingUpAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp[start][0]);
        this.standingLeftAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp[start + 1][0]);
        this.standingDownAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp[start + 2][0]);
        this.standingRightAnimation = new Animation<TextureRegion>(FRAME_DURATION, temp[start + 3][0]);

        this.currentAnimation = this.downWalkAnimation;
        this.currentStandingAnimation = this.standingDownAnimation;
        this.walking = false;
//        this.animation = new Animation<TextureRegion>(0.25f, walkFrames);

        stateTime = 0f;

        this.sprite = new Sprite(temp[start][0]);


        float viewportWidth = Gdx.graphics.getWidth();
        float viewportHeight = Gdx.graphics.getHeight();
        this.textureWidth = (float) this.texture.getWidth() / FRAME_COLS;
        this.textureHeight = (float) this.texture.getHeight() / FRAME_ROWS;

        this.sprite.setPosition(viewportWidth / 2 - this.textureWidth / 2, viewportHeight / 2 - this.textureHeight / 2);
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(0, 0);
        }
        return player;

    }

    public void render(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

//        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame;
//
        if (this.walking) {
            currentFrame = this.currentAnimation.getKeyFrame(stateTime, true);
        } else {
            currentFrame = this.currentStandingAnimation.getKeyFrame(stateTime, true);
        }

        this.sprite.setRegion(currentFrame);

        sprite.draw(batch);
    }

    public void update(float mapWidth, float mapHeight) {
        if (this.getPosX() < 0) { this.setPosX(0); }
        if (this.getPosY() < 0) { this.setPosY(0); }
        if (this.getPosX() > mapWidth) { this.setPosX((int) mapWidth); }
        if (this.getPosY() > mapHeight) { this.setPosY((int) mapHeight); }

    }

    public void setSpritePosX(float x) {
        this.sprite.setPosition(x, this.sprite.getY());
    }

    public int getSpritePosX() {
        return (int) this.sprite.getX();
    }

    public void setSpritePosY(float y) {
        this.sprite.setPosition(this.sprite.getX(), y);
    }

    public int getSpritePosY() {
        return (int) this.sprite.getY();
    }

    public TextureRegion getCurrentFrame(float batch) {
        return this.currentAnimation.getKeyFrame(batch, true);
    }

    public void setCurrentAnimation(Animation<TextureRegion> currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    public void setCurrentStandingAnimation(Animation<TextureRegion> currentStandingAnimation) {
        this.currentStandingAnimation = currentStandingAnimation;
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

    public boolean isWalking() {
        return walking;
    }

    public void setWalking(boolean walking) {
        this.walking = walking;
    }

    public float getTextureHeight() {
        return textureHeight;
    }

    public float getTextureWidth() {
        return textureWidth;
    }
}

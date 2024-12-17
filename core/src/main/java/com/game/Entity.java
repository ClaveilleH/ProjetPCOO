package com.game;

public class Entity {
    private int posX;
    private int posY;

    private int hp;
    public Entity(int x, int y ) {
        this.posX = x;
        this.posY = y;
        this.hp = 100;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

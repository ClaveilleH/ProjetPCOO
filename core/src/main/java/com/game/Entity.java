package com.game;

public class Entity {
    private int x;
    private int y;

    private int hp;
    public Entity(int x, int y ) {
        this.x = x;
        this.y = y;
        this.hp = 100;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
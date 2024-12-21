package com.game.controls;

import com.game.Player;


public class MovementUp implements Movement{
    private int key;
    private Player player;
    private Movement nextMovement;

    public MovementUp(int key) {
        this.key = key;
        this.player = Player.getPlayer();
    }

    @Override
    public void setNext(Movement next) {
        this.nextMovement = next;
    }

    public boolean pass(int key){
        if (this.key == key){
            this.action();
            return true;
        }
        return this.nextMovement.pass(key);
    }

    @Override
    public boolean action(){
        player.setPosY(player.getPosY() + 10);
        player.setCurrentAnimation(player.getUpWalkAnimation());
        return true;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}

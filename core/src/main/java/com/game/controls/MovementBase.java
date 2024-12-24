package com.game.controls;

import com.game.GameModel;
import com.game.Player;


public abstract class MovementBase implements Movement {
    protected int key;
    protected Player player;
    protected Movement nextMovement;
    protected GameModel model;

    public MovementBase(int key) {
        this.key = key;
        this.player = Player.getPlayer();
        this.model = GameModel.getGame();
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
        if (this.nextMovement != null){
            return this.nextMovement.pass(key);
        }
        return false;
    }

    @Override
    public boolean action(){
        player.setPosY(player.getPosY() - this.model.getPlayerSpeed());
        player.setCurrentAnimation(player.getDownWalkAnimation());
        return true;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}

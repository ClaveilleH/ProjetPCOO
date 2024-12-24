package com.game.controls;


public class MovementLeft extends MovementBase implements Movement {

    public MovementLeft(int key) {
        super(key);
    }

    @Override
    public boolean action() {
        super.player.setPosX(super.player.getPosX() - super.model.getPlayerSpeed());
        super.player.setCurrentAnimation(super.player.getLeftWalkAnimation());
        return true;
    }
}

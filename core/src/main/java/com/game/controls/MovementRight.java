package com.game.controls;


public class MovementRight extends MovementBase implements Movement {

    public MovementRight(int key) {
        super(key);
    }

    @Override
    public boolean action() {
        super.player.setPosX(super.player.getPosX() + super.model.getPlayerSpeed());
        super.player.setCurrentAnimation(super.player.getRightWalkAnimation());
        return true;
    }
}

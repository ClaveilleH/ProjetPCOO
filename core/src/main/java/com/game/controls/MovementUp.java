package com.game.controls;

import com.game.GameModel;
import com.game.Player;


public class MovementUp extends MovementBase implements Movement {

    public MovementUp(int key) {
        super(key);
    }

    @Override
    public boolean action() {
        super.player.setPosY(super.player.getPosY() + super.model.getPlayerSpeed());
        super.player.setCurrentAnimation(super.player.getUpWalkAnimation());
//        su
        return true;
    }
}

package com.game.controls;

import com.game.GameModel;
import com.game.Player;


public class MovementDown extends MovementBase implements Movement {

    public MovementDown(int key) {
        super(key);
    }

    @Override
    public boolean action() {
        super.player.setPosY(super.player.getPosY() - super.model.getPlayerSpeed());
        super.player.setCurrentAnimation(super.player.getDownWalkAnimation());
        return true;
    }
}

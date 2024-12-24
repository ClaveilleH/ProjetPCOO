package com.game.controls;

import com.badlogic.gdx.Input;
import com.game.Player;
import com.game.PlayerInputProcessor;

import java.util.ArrayList;

public class ControlsManager {
    private static ControlsManager instance;

    private PlayerInputProcessor playerInputProcessor;
    private Player player;

    private Movement movementUp;
    private Movement movementDown;
    private Movement movementLeft;
    private Movement movementRight;

    private Movement firstChain;


    private ControlsManager() {
//        this.game = Game.getInstance();
        this.playerInputProcessor = PlayerInputProcessor.getInstance();
        this.movementUp = new MovementUp(Input.Keys.UP);
        this.movementDown = new MovementDown(Input.Keys.DOWN);
        this.movementLeft = new MovementLeft(Input.Keys.LEFT);
        this.movementRight = new MovementRight(Input.Keys.RIGHT);

        this.movementUp.setNext(this.movementDown);
        this.movementDown.setNext(this.movementLeft);
        this.movementLeft.setNext(this.movementRight);
//        this.movementRight.setNext();

        this.firstChain = this.movementUp;

        this.player = Player.getPlayer();
    }

    public void update() {
//        System.out.println(this.playerInputProcessor.getKeysPressed());
        ArrayList<Integer> list = this.playerInputProcessor.getKeysPressed();
        if ( !( list == null || list.isEmpty())) {
            this.player.setWalking(true);
//            System.out.println(this.player.isWalking());
//            System.out.println(list.toString());
            for (int key : list) {
                this.firstChain.pass(key);
//                System.out.println(key);
            }
        } else {
            // mettre en standing
            this.player.setWalking(false);
        }
    }


    public static ControlsManager getInstance() {
        if (instance == null) {
            instance = new ControlsManager();
        }
        return instance;
    }

}

package com.game;

public class Player extends Entity {
    private static Player player;

    private Player(int x, int y) {
        super(x, y);
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(0, 0);
        }
        return player;
    }
}

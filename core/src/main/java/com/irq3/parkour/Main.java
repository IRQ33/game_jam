package com.irq3.parkour;

import com.badlogic.gdx.Game;

public class Main extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
}

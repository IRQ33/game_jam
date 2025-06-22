package com.irq3.parkour;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.irq3.parkour.Levels.Level;
import com.irq3.parkour.Levels.TestLevel;
import com.irq3.parkour.Managers.InputManager;

public class FirstScreen implements Screen, ChgGame{

    SpriteBatch batch;
    Level mainLevel;
    InputManager manager;

    @Override
    public void show() {
        batch =  new SpriteBatch();
        mainLevel = new TestLevel(batch,this, false);
        mainLevel.init();
        manager = new InputManager();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GREEN);
        mainLevel.specialUpdate();
        batch.begin();
        mainLevel.getMovement(manager);
        mainLevel.update();
        batch.end();

    }

    @Override
    public void resize(int width, int height) {


        if(width <= 0 || height <= 0) return;

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void changeLeve(Level level) {
        this.mainLevel.dispose();
        this.mainLevel = level;
        level.init();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

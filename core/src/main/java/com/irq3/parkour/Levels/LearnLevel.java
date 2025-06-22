package com.irq3.parkour.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.irq3.parkour.ChgGame;
import com.irq3.parkour.Elements.*;
import com.irq3.parkour.Managers.InputManager;
import com.irq3.parkour.Managers.ZombieManager;

import java.util.ArrayList;
import java.util.List;

public class LearnLevel implements Level{

    BetterPlayer player;
    SpriteBatch batch;
    public List<Element> eltList;
    InputManager manager;
    Music music;
    List<Element> add = new ArrayList<>();

    @Override
    public List<Element> addo() {
        return add;
    }


    @Override
    public List<Element> main() {
        return  eltList;
    }

    @Override
    public List<Element> dello() {
        return del;
    }

    List<Element> del = new ArrayList<>();
    boolean playing = true;
    ZombieManager zManager;
    ChgGame game;
    public boolean thisgame=true;

    public LearnLevel(SpriteBatch batch, ChgGame game) {
        this.batch = batch;
        this.game = game;
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setVolume(0.7f);
    }

    @Override
    public void init() {
        eltList = new ArrayList<>();
        player = new BetterPlayer(200,200,this);
        zManager = new ZombieManager(game,player,add,this, batch);

        music.play();
        eltList.add(player);
    }

    @Override
    public void update() {
        if(thisgame)
        {
            ScreenUtils.clear(Color.CORAL);
            zManager.update();
            for (Element e: eltList)
            {
                e.update(batch);
            }
            eltList.addAll(add);
            eltList.removeAll(del);
        }
    }

    @Override
    public void getMovement(InputManager manager) {
        player.specialUpdate(manager);

    }

    @Override
    public void specialUpdate() {

    }
    public void  addo(Element element)
    {
        add.add(element);
    }
    public void dello(Element e)
    {
        del.add(e);
    }

    @Override
    public void dispose() {
        music.dispose();

    }
}

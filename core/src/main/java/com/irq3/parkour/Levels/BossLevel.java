package com.irq3.parkour.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;
import com.irq3.parkour.ChgGame;
import com.irq3.parkour.Elements.Ball;
import com.irq3.parkour.Elements.BetterPlayer;
import com.irq3.parkour.Elements.Boss;
import com.irq3.parkour.Elements.Element;
import com.irq3.parkour.Managers.InputManager;

import java.security.interfaces.ECKey;
import java.util.ArrayList;
import java.util.List;

public class BossLevel implements Level{

    BetterPlayer player;
    List<Element> add;
    List<Element> del;
    List<Element> mainList;
    SpriteBatch batch;
    ChgGame game;
    Music music;
    Boss boss;
    BitmapFont font;

    public BossLevel(SpriteBatch batch, ChgGame game) {
        this.batch = batch;
        this.game = game;
    }

    @Override
    public List<Element> addo() {
        return add;
    }

    @Override
    public List<Element> main() {
        return mainList ;
    }

    @Override
    public List<Element> dello() {
        return del;
    }

    @Override
    public void init() {
        player =  new BetterPlayer(200,200,this);
        add = new ArrayList<>();
        del = new ArrayList<>();
        mainList = new ArrayList<>();
        music = Gdx.audio.newMusic(Gdx.files.internal("music2.mp3"));
        music.play();
        boss = new Boss(300,300,player, game);
        mainList.add(player);
        mainList.add(boss);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fontt.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size=20;
        parameter.minFilter = Texture.TextureFilter.Linear;
        font = generator.generateFont(parameter);

    }

    @Override
    public void update() {
        ScreenUtils.clear(Color.CORAL);
        for (Element e: mainList)
        {
            e.update(batch);
        }
        font.draw(batch,"Player: "+player.getLife()+ "/30",450,450);
        mainList.addAll(add);
        mainList.removeAll(del);

        if(boss.getLife()<0)
        {
            game.changeLeve(new TestLevel(batch,game,false,true));
        }
        if(player.getLife()<=0)
        {
            game.changeLeve(new TestLevel(batch,game, true));
        }
    }

    @Override
    public void getMovement(InputManager manager) {
        player.specialUpdate(manager);

    }

    @Override
    public void specialUpdate() {

    }

    @Override
    public void dispose() {
        music.dispose();

    }
}

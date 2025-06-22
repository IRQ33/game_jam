package com.irq3.parkour.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.irq3.parkour.ChgGame;
import com.irq3.parkour.Elements.Ball;
import com.irq3.parkour.Elements.Cave;
import com.irq3.parkour.Elements.Element;
import com.irq3.parkour.Elements.Player;
import com.irq3.parkour.Managers.InputManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestLevel implements Level{
    List<Element> elements;
    Player player;
    SpriteBatch batch;
    ShapeRenderer renderer;
    Cave firstLevel;
    Cave secondLevel;
    BitmapFont font;
    ChgGame game;
    boolean life = false;
    boolean win = false;
    public TestLevel(SpriteBatch batch, ChgGame game, boolean life) {
        this.batch = batch;
        this.game = game;
        this.life =life;
        elements = new ArrayList<>();
        renderer = new ShapeRenderer();
    }
    public TestLevel(SpriteBatch batch, ChgGame game, boolean life, boolean win) {
        this.batch = batch;
        this.game = game;
        this.life =life;
        this.win = win;
        elements = new ArrayList<>();
        renderer = new ShapeRenderer();
    }

    @Override
    public List<Element> addo() {
        return null;
    }

    @Override
    public List<Element> main() {
        return elements;
    }

    @Override
    public List<Element> dello() {
        return null;
    }

    @Override
    public void init() {
        player = new Player(210,100,0);
        firstLevel = new Cave(120,200,player,true, game);
        secondLevel = new Cave(300,200,player,false, game);

        elements.add(player);
        elements.add(firstLevel);
        elements.add(secondLevel);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fontt.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size=20;
        parameter.minFilter = Texture.TextureFilter.Linear;
        font = generator.generateFont(parameter);

    }

    @Override
    public void update() {
        font.draw(batch,"Learn",120,300);
        font.draw(batch,"Boss",300,300);

        if(life&&!win)
        {
            font.draw(batch,"You dead!!!",230,400);
        }
        if(win)
        {
            font.draw(batch,"You win!!!",230,400);
        }


        for (Element e : elements)
        {
            e.update(batch);
        }
    }

    @Override
    public void specialUpdate() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setColor(Color.GRAY);
        renderer.rect(100,80,400,350);
        renderer.end();
    }

    @Override
    public void getMovement(InputManager manager) {
        if(manager.keys.contains(Input.Keys.W))
        {
            player.velocity(0,1);
        }
        else if(manager.keys.contains(Input.Keys.S))
        {
            player.velocity(0,-1);
        }
        if(manager.keys.contains(Input.Keys.A))
        {
            player.velocity(-1,0);
        }
        if(manager.keys.contains(Input.Keys.D))
        {
            player.velocity(1,0);
        }
    }

    @Override
    public void dispose() {

    }
}

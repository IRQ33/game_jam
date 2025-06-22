package com.irq3.parkour.Managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.irq3.parkour.ChgGame;
import com.irq3.parkour.Elements.BetterPlayer;
import com.irq3.parkour.Elements.Element;
import com.irq3.parkour.Elements.Player;
import com.irq3.parkour.Elements.Zombie;
import com.irq3.parkour.Levels.LearnLevel;
import com.irq3.parkour.Levels.Level;
import com.irq3.parkour.Levels.TestLevel;

import java.util.ArrayList;
import java.util.List;

public class ZombieManager {
    int timer=0;
    List<Zombie> zombies;
    ChgGame game;
    BetterPlayer player;
    List<Element> addElements;
    LearnLevel level;
    boolean checkzombies;
    SpriteBatch batch;
    int ntimer;


    public ZombieManager(ChgGame game, BetterPlayer player, List<Element> addElements, LearnLevel level, SpriteBatch batch) {
        this.player = player;
        this.game =game;
        this.addElements =addElements;
        this.level =level;
        this.batch =batch;
        zombies = new ArrayList<>();
        zombies.add(new Zombie(500,500, 1f,player,game, level));
        zombies.add(new Zombie(700,100, 1f,player,game, level));
        zombies.add(new Zombie(900,-200, 1f,player,game, level));
        zombies.add(new Zombie(-300,500, 1f,player,game, level));
    }

    public void update()
    {
        ntimer++;
        if(!zombies.isEmpty())
            timer++;

        if(timer>300 && !zombies.isEmpty()) {

            Zombie z = zombies.removeFirst();
            if (!addElements.contains(z)) {
                addElements.add(z);
            }
            timer = 0;

        }

        System.out.println(checkzombies);
        if(ntimer>600)
        {
            checkzombies=true;
        }
        if(checkzombies)
        {
            if(level.eltList.stream().noneMatch(obj -> obj instanceof Zombie))
            {
                game.changeLeve(new TestLevel(batch,game,false, true));
            }
        }
    }
}

package com.irq3.parkour.Elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.irq3.parkour.ChgGame;
import com.irq3.parkour.Levels.TestLevel;

public class Boss extends Element{

    private BetterPlayer player;
    private float speed=5;
    private int timer;
    private final int timeToMove=5;
    private ChgGame game;
    private int stimer=0;
    int cooldown=300;
    int lastLife;
    private boolean cooown;

    public Boss(float posX, float posY, BetterPlayer player, ChgGame game) {
        super(posX, posY, 80, 80, "brocol",600);
        this.player = player;
        this.game =game;
        lastLife= this.getLife();
    }

    @Override
    public void update(SpriteBatch batch) {
        this.sprite.draw(batch);
        stimer+=1;

        System.out.println("My life:" + this.getLife());
        if(!cooown && getLife()<=lastLife-100)
        {
            cooown = true;
            speed=0;
        }
        if(cooown)
        {
            cooldown--;
            if(cooldown<=0)
            {
                speed=5;
                cooown=false;
                lastLife= getLife();
            }
        }

        if (checkCollision(player)&& stimer>=300)
        {
            player.setLife(player.getLife()-5);
            stimer=0;
        }

        timer++;
        if(timer>timeToMove)
        {
            move();
            timer=0;
        }

    }

    private void move() {
        if(player.getPosX()>this.getPosX())
        {
            velocity(speed,0);
        }if(player.getPosX()<this.getPosX())
        {
            velocity(-speed,0);
        }if(player.getPosY()>this.getPosY())
        {
            velocity(0,speed);
        }
        if(player.getPosY()<this.getPosY())
        {
            velocity(0,-speed);
        }
    }


}

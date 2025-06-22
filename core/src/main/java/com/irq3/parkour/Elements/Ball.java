package com.irq3.parkour.Elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.irq3.parkour.Levels.LearnLevel;
import com.irq3.parkour.Levels.Level;

import java.util.Arrays;
import java.util.List;

public class Ball extends Element{
    int dir;
    BetterPlayer player;
    boolean ftime=false;
    Level level;
    int timer;
    float force = 0.2f;

    public Ball(float posX, float posY, int dir, BetterPlayer player, Level level) {
        super(posX, posY, 10,10, "srslyno2sec",2);
        this.dir = dir;
        this.player = player;
        this.level = level;
    }

    @Override
    public void update(SpriteBatch batch) {
        this.sprite.draw(batch);
        timer++;
        switch (dir)
        {
            case 1->{
                if(!ftime)
                {
                    this.setPosX(player.getPosX());
                    this.setPosY(player.getPosY()+5);
                    ftime= true;
                }

                this.velocity(0,force);
            }
            case 2->{
                if(!ftime)
                {
                    this.setPosX(player.getPosX());
                    this.setPosY(player.getPosY()-5);
                    ftime= true;

                }
                this.velocity(0,-force);

            }
            case 3->{
                if(!ftime)
                {
                    this.setPosX(player.getPosX()+5);
                    this.setPosY(player.getPosY());
                    ftime= true;

                }
                this.velocity(force,0);

            }
            case 4->{
                if(!ftime)
                {
                    this.setPosX(player.getPosX()-5);
                    this.setPosY(player.getPosY());
                    ftime= true;

                }
                this.velocity(-force,0);

            }
        }

        for (Element element : level.main())
        {
            if(checkCollision(element)&& !(element instanceof  BetterPlayer) && !(element instanceof  Ball))
            {
                level.dello().add(this);
                element.setLife(element.getLife()-2);
                if(element.getLife()<1)
                {
                    level.dello().add(element);
                }

                System.out.println(element.getLife());
            }
        }

        if(timer>10000) level.dello().add(this);
    }

}

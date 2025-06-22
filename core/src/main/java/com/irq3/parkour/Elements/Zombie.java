package com.irq3.parkour.Elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.irq3.parkour.ChgGame;
import com.irq3.parkour.Levels.LearnLevel;
import com.irq3.parkour.Levels.Level;
import com.irq3.parkour.Levels.TestLevel;

public class Zombie extends Element{

    float speed=2f;
    BetterPlayer player;
    int timer;
    float timeToMove =200;
    ChgGame game;
    Level level;
    public Zombie(float posX, float posY, float speed, BetterPlayer player, ChgGame game, Level level) {
        super(posX, posY, 30,30, "zombie",2);
        this.speed = speed;
        this.player = player;
        this.game = game;
        this.level = level;
    }

    @Override
    public void update(SpriteBatch batch) {
        this.sprite.draw(batch);
        timer++;
        if(timer>timeToMove)
        {
            move();
            timer=0;
        }
        if(this.checkCollision(player))
        {
            level.dello().add(this);
            game.changeLeve(new TestLevel(batch,game,true));

        }

    }

    private void move() {
        if(player.getPosX()>this.getPosX())
        {
            velocity(speed,0);
        }else if(player.getPosX()<this.getPosX())
        {
            velocity(-speed,0);
        }else if(player.getPosY()>this.getPosY())
        {
            velocity(0,speed);
        }
        else if(player.getPosY()<this.getPosY())
        {
            velocity(0,-speed);
        }
    }


}

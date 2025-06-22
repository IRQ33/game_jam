package com.irq3.parkour.Elements;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.irq3.parkour.Levels.LearnLevel;
import com.irq3.parkour.Levels.Level;
import com.irq3.parkour.Managers.InputManager;

import java.util.List;

public class BetterPlayer extends Element{

    OrthographicCamera camera;
    Level level;
    int time;
    public BetterPlayer(float posX, float posY, Level level) {
        super(posX, posY, 30,30,"player",30);
        this.level = level;
        camera = new OrthographicCamera(400,400);
    }

    @Override
    public void update(SpriteBatch batch) {
        time++;
        this.sprite.draw(batch);

    }
    public void specialUpdate(InputManager manager)
    {
        if(getPosX()>600)
        {
            velocity(-1,0);
        }
        if(getPosX()<-500)
        {
            velocity(1,0);
        }
        if(getPosY()>500)
        {
            velocity(0,-1);
        }
        if(getPosY()<-500)
        {
            velocity(0,1);
        }
        if(manager.keys.contains(Input.Keys.W))
        {
            if(canMove())
                this.velocity(0,1);
        }
        if(manager.keys.contains(Input.Keys.S))
        {
            if(canMove())
                this.velocity(0,-1);
        }
        if(manager.keys.contains(Input.Keys.D))
        {
            if(canMove())
                this.velocity(1,0);
        }
        if(manager.keys.contains(Input.Keys.A))
        {
            if(canMove())
                this.velocity(-1,0);
        }
        if(time>100)
        {
            if(manager.keys.contains(Input.Keys.UP))
            {
                level.addo().add(new Ball(this.getPosX(),this.getPosY(),1,this,level)); time=0;
            }
            if(manager.keys.contains(Input.Keys.DOWN))
            {
                level.addo().add(new Ball(this.getPosX(),this.getPosY(),2,this,level)); time=0;
            }
            if(manager.keys.contains(Input.Keys.RIGHT))
            {
                level.addo().add(new Ball(this.getPosX(),this.getPosY(),3,this,level)); time=0;
            }
            if(manager.keys.contains(Input.Keys.LEFT))
            {
                level.addo().add(new Ball(this.getPosX(),this.getPosY(),4,this,level)); time=0;
            }


        }
    }
    public boolean canMove()
    {
        return getPosX() <= 600 && getPosX() >= -500 && getPosY() >= -500 && getPosY() <= 500;
    }

}

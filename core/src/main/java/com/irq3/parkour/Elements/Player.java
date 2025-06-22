package com.irq3.parkour.Elements;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Player extends Element{

    OrthographicCamera camera;
    int gravity;

    public Player(float x,float y, int gravity)
    {
        super(x,y,30,30,"player",10);
        camera = new OrthographicCamera(400,400);
        this.gravity = gravity;
    }

    public void update(SpriteBatch batch)
    {
        camera.update();
        this.sprite.draw(batch);
        if(gravity>0)
        {
            movement();
        }
    }

    private void movement()
    {
        if(gravity==1)
        {
            this.velocity(0,-0.01f);
        }
        if(gravity==2)
        {
            this.velocity(0,0.01f);
        }
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}

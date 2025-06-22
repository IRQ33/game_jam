package com.irq3.parkour.Elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Element {
    private float posX,posY;
    private float width,height;
    Sprite sprite;
    int life;


    public Element(float posX, float posY, float width, float height, String name, int life) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.life = life;
        sprite = new Sprite(new Texture(Gdx.files.internal(name+".png")));
        sprite.setPosition(posX,posY);
        sprite.setSize(width,height);
    }

    public abstract void update(SpriteBatch batch);

    public void velocity(float x, float y)
    {
        this.setPosX(this.posX+x);
        this.setPosY(this.posY+y);
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
        this.sprite.setX(posX);
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
        this.sprite.setY(posY);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        this.sprite.setSize(width,this.height);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        this.sprite.setSize(this.width,height);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean checkCollision(Element element) {
        return this.getPosX() < element.getPosX() + element.getWidth() &&
            this.getPosX() + this.getWidth() > element.getPosX() &&
            this.getPosY() < element.getPosY() + element.getHeight() &&
            this.getPosY() + this.getHeight() > element.getPosY();
    }
}

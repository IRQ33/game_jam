package com.irq3.parkour.Elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.irq3.parkour.ChgGame;
import com.irq3.parkour.Levels.BossLevel;
import com.irq3.parkour.Levels.LearnLevel;
import com.irq3.parkour.Levels.Level;

public class Cave extends Element{

    private Player player;
    private static final float width=60,height= 60;
    // 0 - learn, 1 - boss
    private boolean whatMake;
    private ChgGame game;

    public Cave(float posX, float posY, Player player, boolean whatMake,ChgGame game) {
        super(posX, posY, width, height, "caveo",1000);
        this.player = player;
        this.whatMake = whatMake;
        this.game = game;
    }

    @Override
    public void update(SpriteBatch batch) {
        this.sprite.draw(batch);
        if(checkCollision()&& whatMake)
        {
            game.changeLeve(new LearnLevel(batch,game));
        } else if (checkCollision()&&!whatMake) {
            game.changeLeve(new BossLevel(batch,game));
        }
    }

    public boolean checkCollision() {
        return this.getPosX() < player.getPosX() + player.getWidth() &&
            this.getPosX() + this.getWidth() > player.getPosX() &&
            this.getPosY() < player.getPosY() + player.getHeight() &&
            this.getPosY() + this.getHeight() > player.getPosY();
    }

}

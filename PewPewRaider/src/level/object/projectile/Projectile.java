package level.object.projectile;

import graphics.AnimatedSprite;
import graphics.Screen;
import level.object.*;
import level.object.Object;

/**
 * Created by bc013806 on 11/16/2015.
 */
public abstract class Projectile extends Object{
    protected int speed, duration, timer;
    public boolean expired = false;

    public AnimatedSprite sprite;


    public void tick(){
        if(timer >= duration)expired = true;
        x+=speed;
    }

    public void render(Screen screen){

    }

    public void setAnimatedSprite(AnimatedSprite sprite){
        this.sprite = sprite;
    }

}

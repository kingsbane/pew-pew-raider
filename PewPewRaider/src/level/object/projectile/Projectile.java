package level.object.projectile;

import level.object.*;
import level.object.Object;

/**
 * Created by bc013806 on 11/16/2015.
 */
public class Projectile extends Object{
    private int speed, duration, timer;
    public boolean expired = false;

    public Projectile(int x, int y, int speed, int duration){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.duration = duration;
        timer = 0;

    }

    public void tick(){
        if(timer >= duration)expired = true;
    }

    public void render(){

    }

}

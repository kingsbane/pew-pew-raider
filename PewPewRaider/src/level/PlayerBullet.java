package level;

import level.object.projectile.Projectile;

/**
 * Created by bc013806 on 11/16/2015.
 */
public class PlayerBullet extends Projectile {
    public PlayerBullet(int x, int y, int speed, int duration){
        super(x,y,speed,duration);
        timer = 0;
    }
}

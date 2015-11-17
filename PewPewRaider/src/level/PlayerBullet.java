package level;

import graphics.AnimatedSprite;
import graphics.Screen;
import level.object.projectile.Projectile;

/**
 * Created by bc013806 on 11/16/2015.
 */
public class PlayerBullet extends Projectile {
    public PlayerBullet(int x, int y, int speed, int duration){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.duration = duration;
        timer = 0;

        setAnimatedSprite(AnimatedSprite.spr_playerbullet);
        System.out.println("created projectile...");

    }

    public void tick(){
        //System.out.println(sprite.frames);
        sprite.tick();
        x+=speed;
        timer++;
    }

    public void render(Screen screen){
        screen.renderSprite(x,y, sprite.getCurrentFrame());
    }
}

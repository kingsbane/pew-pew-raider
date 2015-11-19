package level.object;

import base.GameWorld;
import event.Keyboard;
import graphics.AnimatedSprite;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import level.Level;
import level.PlayerBullet;
import level.object.projectile.Projectile;

/**
 * Created by area5 on 11/5/2015.
 */

//TODO: get a player walking around on the level

public class Player extends Object{
    public Keyboard key;

    private AnimatedSprite sprite;

    public static final int WALK_SPEED = 2;
    public boolean isRight = true;
    private int dir = 1;
    private int shootTimer = 0;

    public Player(Keyboard key){
        this.key = key;


        setAnimatedSprite(AnimatedSprite.spr_player_static_R);
    }

    public void tick(Level level) {
        int xa = 0, ya = 0;


        key.update();

        //update direction
        if(isRight)dir = 1;
        else      dir = -1;

        //really ugly code that handles movement and sprite changes
        if(key.up){
            ya-= WALK_SPEED;
        }
        if(key.down){
            ya+= WALK_SPEED;
        }
        if(key.left) {
            isRight = false;
            xa -= WALK_SPEED;
            if (!sprite.equals(AnimatedSprite.spr_player_run_L)) setAnimatedSprite(AnimatedSprite.spr_player_run_L);
        }
        if(key.right){
            isRight = true;
            xa+= WALK_SPEED;
            if(!sprite.equals(AnimatedSprite.spr_player_run_R))setAnimatedSprite(AnimatedSprite.spr_player_run_R);
        }
        if(xa == 0){
            //if no horizontal movement
            if( isRight && !sprite.equals(AnimatedSprite.spr_player_static_R))setAnimatedSprite(AnimatedSprite.spr_player_static_R);
            else if(!isRight && !sprite.equals(AnimatedSprite.spr_player_static_L)) setAnimatedSprite(AnimatedSprite.spr_player_static_L);
        }
        move(xa, ya);

        if(key.space) {
            if (shootTimer > 10) {
                shoot(level);
                shootTimer = 0;
            }

        }
        shootTimer++;
        sprite.tick();
    }

    public void move(int xa, int ya){
        x += xa;
        y += ya;

    }

    public void shoot(Level level){
        level.addProjectile(new PlayerBullet(x + sprite.SIZE/2 + (AnimatedSprite.spr_playerbullet.SIZE/2 * dir), y + sprite.SIZE/ 4, 4 * dir, 60));
        shootTimer = 1;
    }

    public void render(Screen screen){ //renders the current frame of the animation
        screen.renderSprite(x, y, sprite.getCurrentFrame());
    }

    public void setAnimatedSprite(AnimatedSprite spr){
        this.sprite = spr;
    }

}
package level.object;

import event.Keyboard;
import graphics.AnimatedSprite;
import graphics.Screen;
import graphics.Spritesheet;

/**
 * Created by area5 on 11/5/2015.
 */

//TODO: get a player walking around on the level

public class Player extends Object{
    public Keyboard key;

    private AnimatedSprite sprite;

    public static final int WALK_SPEED = 2;
    public boolean isRight = true;

    public Player(Keyboard key){
        this.key = key;


        setAnimatedSprite(AnimatedSprite.spr_player_static_R);
    }

    public void tick() {
        int xa = 0, ya = 0;

        key.update();
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
            if( isRight && !sprite.equals(AnimatedSprite.spr_player_run_R))setAnimatedSprite(AnimatedSprite.spr_player_run_R);
            else if(!sprite.equals(AnimatedSprite.spr_player_static_L)) setAnimatedSprite(AnimatedSprite.spr_player_static_L);
        }

        move(xa, ya);

        sprite.tick();
    }

    public void move(int xa, int ya){
        x += xa;
        y += ya;

    }

    public void render(Screen screen){ //renders the current frame of the animation
        screen.renderSprite(x, y, sprite.getCurrentFrame());
    }

    public void setAnimatedSprite(AnimatedSprite spr){
        this.sprite = spr;
    }

}
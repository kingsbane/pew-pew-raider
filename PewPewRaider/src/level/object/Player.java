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

    public Player(Keyboard key){
        this.key = key;


        setAnimatedSprite(AnimatedSprite.spr_player_static_1);
    }

    public void tick() {
        int xa = 0, ya = 0;

        key.update();
        if(key.up)ya-= WALK_SPEED;
        if(key.down)ya+= WALK_SPEED;
        if(key.left)xa-= WALK_SPEED;
        if(key.right)xa+= WALK_SPEED;

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
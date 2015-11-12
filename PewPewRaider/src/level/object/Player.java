package level.object;

import event.Keyboard;

/**
 * Created by area5 on 11/5/2015.
 */
public class Player extends Object{
    public Keyboard key;

    public Player(Keyboard key){
        this.key = key;
    }

    public void tick() {
        int xa = 0, ya = 0;

        key.update();
        if(key.up)ya--;
        if(key.down)ya++;
        if(key.left)xa--;
        if(key.right)xa++;

        move(xa, ya);
    }

    public void move(int xa, int ya){
        x += xa;
        y += ya;

    }

    public void render(){

    }

}
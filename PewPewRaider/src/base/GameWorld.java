package base;

import event.Keyboard;
import graphics.Screen;
import level.Level;

/**
 * Created by BC013806 on 11/11/2015.
 */
public class GameWorld {
    int time;
    private Level level;

    public GameWorld(Keyboard key){
        time = 0;
        level = new Level(256, 256, key);

    }

    public void tick(){
        time++;
        level.tick();
    }

    public void render(Screen screen){
        level.render(screen);
    }
}

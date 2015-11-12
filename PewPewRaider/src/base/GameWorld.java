package base;

import graphics.Screen;
import level.Level;

/**
 * Created by BC013806 on 11/11/2015.
 */
public class GameWorld {
    int time;
    private Level level;

    public GameWorld(){
        time = 0;
        level = new Level(256, 256);

    }

    public void tick(){
        time++;
    }

    public void render(Screen screen){
        level.render(screen);
    }
}

package level;

import event.Keyboard;
import graphics.Screen;
import level.Tile.Tile;
import level.object.Player;

public class Level{
    private int[] tiles;
    public int width, height;
    private Player player;

    public Level(int width, int height, Keyboard key){
        this.width = width;
        this.height = height;

        this.tiles = new int[width*height];
        player = new Player(key);
    }

    public void tick(){
        player.tick();
    }

    public void render(Screen screen){
        player.render(screen);
    }
}
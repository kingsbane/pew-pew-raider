package level;

import graphics.Screen;
import level.Tile.Tile;

public class Level{
    private int[] tiles;
    public int width, height;

    public Level(int width, int height){
        this.width = width;
        this.height = height;

        this.tiles = new int[width*height];
    }

    public void tick(){

    }

    public void render(Screen screen){

    }
}
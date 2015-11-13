package level.Tile;

import graphics.Screen;
import graphics.Sprite;

public class Tile {
    public Sprite sprite;
    int x, y;

    public static Tile tile_void = new VoidTile(Sprite.spr_void);
    public static Tile tile_wall = new WallTile(Sprite.spr_wall);

    public Tile(Sprite sprite){
        this.sprite = sprite;
    }


    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 3, y << 3, this);
    }

    public void tick(){

    }
}

package level;

import event.Keyboard;
import graphics.Screen;
import level.Tile.Tile;
import level.object.*;
import level.object.Object;
import level.object.projectile.Projectile;

import java.util.ArrayList;

public class Level{
    private int[] tiles;
    public int width, height;
    private Player player;

    private ArrayList<Projectile> projectiles = new ArrayList<>();

    public Level(int width, int height, Keyboard key){
        this.width = width;
        this.height = height;

        this.tiles = new int[width*height];
        player = new Player(key);
    }

    public void tick(){
        player.tick(this);
        for(Projectile p : projectiles){
            if(p.expired){
                p = null;
                break;
            }
            p.tick();
        }
    }

    public void render(Screen screen){
        player.render(screen);
        for(Projectile p : projectiles){
            p.render();
        }
    }

    public void addProjectile(Projectile p){
        projectiles.add(p);
    }
}
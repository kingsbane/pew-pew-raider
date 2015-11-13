package graphics;

import java.util.ArrayList;

/**
 * Created by area5 on 11/5/2015.
 */
public class AnimatedSprite {
    private Spritesheet spritesheet;
    public int frames, frameIndex;
    private int x, y;
    public final int SIZE;
    private int time, speed;


    private ArrayList<Sprite> sprites = new ArrayList<>();

    public static AnimatedSprite spr_player_static_R = new AnimatedSprite(0, 0, 16, 5, 10, Spritesheet.playerSpritesheet);
    public static AnimatedSprite spr_player_run_R = new AnimatedSprite(0, 16, 16, 4, 7, Spritesheet.playerSpritesheet);
    public static AnimatedSprite spr_player_static_L = new AnimatedSprite(0, 48, 16, 5, 10, Spritesheet.playerSpritesheet);
    public static AnimatedSprite spr_player_run_L = new AnimatedSprite(0, 32, 16, 4, 7, Spritesheet.playerSpritesheet);

    public AnimatedSprite(int x, int y, int size, int frames, int speed, Spritesheet spritesheet){
        this.x = x;
        this.y = y;
        this.frames = frames;
        this.spritesheet = spritesheet;
        this.SIZE = size;
        this.speed = speed;
        time = 1;

        load();
    }

    public void tick(){
        time++;

        if(time % speed == 0){
            advanceToNextFrame();
        }
        System.out.println("player ticked");
    }

    private void load(){
        for(int i = 0; i < frames; i++){
            sprites.add(new Sprite(SIZE, x + SIZE * i, y, spritesheet));
        }
    }

    private void advanceToNextFrame(){
        frameIndex++;
        frameIndex %= frames;

        System.out.println("frame advanced...");
    }

    public Sprite getCurrentFrame(){
        return sprites.get(frameIndex);
    }



}

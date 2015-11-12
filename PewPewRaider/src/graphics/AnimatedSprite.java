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

    public AnimatedSprite(int x, int y, int size, int frames, int speed, Spritesheet spritesheet){
        this.frames = frames;
        this.spritesheet = spritesheet;
        this.SIZE = size;
        this.speed = speed;

        load();
    }

    public void tick(){
        time++;
        if(time % speed == 0){
            advanceToNextFrame();
        }
    }

    private void load(){
        for(int i = 0; i < frames; i++){
            sprites.add(new Sprite(SIZE, x + SIZE * i, y, spritesheet));
        }
    }

    private void advanceToNextFrame(){
        frameIndex++;
        if(frameIndex > frames) frameIndex = 0;
    }



}

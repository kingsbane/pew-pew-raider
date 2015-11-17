package level.object;

import graphics.AnimatedSprite;
import graphics.Screen;
import graphics.Sprite;

public abstract class Object {
    public int x, y, size;
    public boolean active = true;
    protected AnimatedSprite sprite;

    public void render(Screen screen){

    }

    public void tick(){

    }

    public void setAnimatedSprite(AnimatedSprite sprite){
        this.sprite = sprite;
    }
}

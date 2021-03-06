package graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Spritesheet{

    private String path;
    public final int SIZE;
    public int[] pixels;

    //public static Spritesheet spritesheet = new Spritesheet("Spritesheet.png" , 64);
    public static Spritesheet playerSpritesheet = new Spritesheet("PlayerSpritesheet.png" , 128);
    public static Spritesheet projectileSpritesheet = new Spritesheet("ProjectileSpritesheet.png" , 80);

    public Spritesheet(String path, int size){
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        load();
    }

    private void load(){ //loads the image as a buffered image and sets the RGB values to pixel[]
        try{
            BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
            System.out.println("loaded the spritesheet...");

            for(int i = 0; i < pixels.length; i++){
                if(pixels[i] == -65281)pixels[i] = -1;
            }

        } catch(IOException e){
            e.printStackTrace();
            System.out.println("unable to load the spritesheet...");
        }

    }

}

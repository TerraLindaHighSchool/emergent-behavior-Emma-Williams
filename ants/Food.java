import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * What the Ant eats.
 * 
 * @author Emma Williams 
 * @version 5/5/20
 */
public class Food extends Actor
{
    private GreenfootImage image;
    private int crumbs = 50;
    private int size = 40;
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Food() 
    { 
        image = new GreenfootImage(size, size);
        updateImage();
    }    
    
    private void updateImage()
    {
        Random random = new Random();
        
        for(int z = 0; z < crumbs; z++)
        {
           int stDev = size / 6;
           int x = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
           int y = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
                     
           // keep crumbs in image
           if(x < 0) 
             x = 0;
                 
           if(x >= size) 
             x = size - 1;
                 
           if(y < 0) 
             y = 0;
                 
           if(y >= size) 
             y = size - 1;
           Color color = new Color(0, 204, 0);  
           image.setColorAt(x, y, color); 
        }
        setImage(image);
    }
    
    public void removeCrumb()
    {
        crumbs--;
        image.clear();
        updateImage();
        if (crumbs == 0)
        {
            getWorld().removeObject(this);
        }
    }
}

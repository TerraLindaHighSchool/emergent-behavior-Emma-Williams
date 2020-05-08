import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * What ants use to mark a trail towards food.
 * 
 * @author Emma Williams
 * @version 5/7/20
 */
public class Pheromone extends Actor
{
    private Greenfoot image;
    private static int MAX_INTENSITY = 180;
    private int intensity;
    private int size;
    /**
     * Act - do whatever the Pheromone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        intensity--;
        if(intensity <= 0)
        {
            // to be implemented
        }
        else
        {
             if ((intensity % 6) == 0)  // prevents updating too often
             { 
                 updateImage();
             }
        }
    }    
    
    public Pheromone()
    {
        intensity = MAX_INTENSITY;
    }
    
    public void updateImage()
    {
        int size = intensity / 3 + 5;
        GreenfootImage image = new GreenfootImage(size + 1, size + 1);
        int alpha = intensity / 3;
        image.setColor(new Color(255, 255, 255, alpha));
        image.fillOval(0, 0, size, size);
        image.setColor(Color.DARK_GRAY);
        image.fillRect(size / 2, size / 2, 2, 2);   
        setImage(image);
    }
}

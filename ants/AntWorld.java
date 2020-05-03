import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The world where ants live.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class AntWorld extends World
{
    public static final int SIZE = 640;

    /**
     * Create a new world. It will be initialised with a few ant hills
     * and food sources
     */
    public AntWorld()
    {
        super(SIZE, SIZE, 1);
        setPaintOrder(Ant.class, AntHill.class);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        AntHill antHill = new AntHill(10);
        addObject(antHill,289,268);
        removeObject(antHill);
        AntHill antHill2 = new AntHill();
        addObject(antHill2,294,277);
        Food food = new Food();
        addObject(food,434,476);
        Food food2 = new Food();
        addObject(food2,378,123);
        Food food3 = new Food();
        addObject(food3,151,214);
        Food food4 = new Food();
        addObject(food4,155,480);
        Food food5 = new Food();
        addObject(food5,399,141);
        Food food6 = new Food();
        addObject(food6,67,44);
        Food food7 = new Food();
        addObject(food7,141,491);
        Food food8 = new Food();
        addObject(food8,430,492);
        Food food9 = new Food();
        addObject(food9,596,362);
    }
}

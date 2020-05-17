import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
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
    public void act()
    {
        List<Food> foods = getObjects(Food.class);
        List<Pheromone> pheromones = getObjects(Pheromone.class);
        if(foods.size()  == 0 && pheromones.size() == 0)
       {
         Greenfoot.stop();    
       }
    }
     
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
        AntHill antHill3 = new AntHill();
        addObject(antHill3,226,536);
        antHill2.setLocation(517,241);
        antHill3.setLocation(96,318);
        AntHill antHill4 = new AntHill();
        addObject(antHill4,352,530);
        antHill3.setLocation(107,275);
        antHill2.setLocation(495,78);
        food5.setLocation(348,285);
        food2.setLocation(367,103);
        Food food10 = new Food();
        addObject(food10,367,103);
        food2.setLocation(365,83);
        Food food11 = new Food();
        addObject(food11,365,83);
        food2.setLocation(378,93);
        Food food12 = new Food();
        addObject(food12,378,93);
        food3.setLocation(165,154);
        food3.setLocation(236,178);
        food.setLocation(545,544);
        food.setLocation(545,515);
        food5.setLocation(337,321);
        food7.setLocation(92,539);
        food4.setLocation(112,513);
        food7.setLocation(106,525);
        food8.setLocation(454,395);
        food7.setLocation(88,513);
        food4.setLocation(208,577);
        food4.setLocation(76,437);
        food2.setLocation(57,153);
        food6.setLocation(93,34);
        food2.setLocation(585,232);
        food2.setLocation(240,48);
        food2.setLocation(401,195);
        food11.setLocation(591,190);
        removeObject(food12);
        removeObject(food10);
        removeObject(food6);
        removeObject(food7);
        removeObject(food2);
        food3.setLocation(176,163);
        food3.setLocation(182,128);
        removeObject(food9);
        removeObject(food8);
        food5.setLocation(346,320);
        removeObject(food);
        food5.setLocation(513,459);
        food5.setLocation(410,354);
    }
}

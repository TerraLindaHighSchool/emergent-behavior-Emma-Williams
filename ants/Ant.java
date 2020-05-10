import greenfoot.*;

/**
 * An ant that collects food.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Ant extends Creature
{
    private boolean carryingFood = false;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int MAX_PH_AVAILABLE = 16;
    private int TIME_FOLLOWING_TRAIL = 30;
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
        image1 = getImage();
        image2 = new GreenfootImage("ant-with-food.gif");
        int phAvailable = MAX_PH_AVAILABLE;
        int followTrialTimeRemaining = 0;
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        status();
    }
    
    private void checkForFood()
    {
        Food food = (Food) getOneIntersectingObject(Food.class);
        if (food != null) 
        {
            carryingFood = true;
            setImage(image2);
            food.removeCrumb();
        }
    }
    
    private boolean atHome()
    {
        if (getHomeHill() != null) 
        {
            return (Math.abs(getX() - getHomeHill().getX()) < 4) && 
            (Math.abs(getY() - getHomeHill().getY()) < 4);
        }
         else
        {
            return false;
        }
     }
     
    private void searchForFood()
    {
        if(followTrailTimeRemaining == 0)
       { 
           walkTowardsPheromoneCenter(); // if ants smells a pheromone, walk toward center of the pheromone droplet
           randomWalk(); // otherwise walk around randomly
       }  
        else
       {
           followTrailTimeRemaining--; // decrement time remaining
           walkAwayFromHome();
       }
       checkForFood();
    }

    private void status()
    {
        if (carryingFood)
        {
         walkTowardsHome();
         handlePheromoneDrop();
        if (atHome())
          {
            setImage(image1);
            carryingFood = false;
            getHomeHill().countFood();
          }  
        }
         else 
        {
            searchForFood();
        }
    }
    
    private void handlePheromoneDrop()
    {    
    }
    
    public boolean smellPheromone()
    {
        
    }
    
    private void walkTowardsPheromoneCenter()
    {
        
    }
}
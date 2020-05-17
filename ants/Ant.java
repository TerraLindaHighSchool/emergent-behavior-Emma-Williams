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
    private int MAX_PH_AVAILABLE = 8;
    private int TIME_FOLLOWING_TRAIL = 30;
    private int followTrailTimeRemaining = 0;
    private int phAvailable = MAX_PH_AVAILABLE;
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
        image1 = getImage();
        image2 = new GreenfootImage("ant-with-food.gif");
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
           walkTowardsPheromoneCenter(); 
           randomWalk(); 
       }  
        else
       {
           followTrailTimeRemaining--; 
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
      if (phAvailable == MAX_PH_AVAILABLE)
      {
          Pheromone ph = new Pheromone();
          getWorld().addObject(ph, getX(), getY());
          phAvailable = 0;
      }
      else
      {
          phAvailable++;
      }
    }
    
    public boolean smellPheromone()
    {
       Actor ph = getOneIntersectingObject(Pheromone.class);
       return (ph != null);   
    }
    
    private void walkTowardsPheromoneCenter()
    {
        Actor ph = getOneIntersectingObject(Pheromone.class);
        if (ph != null) 
        {
            headTowards(ph);
            walk();
            if (ph.getX() == getX() && ph.getY() == getY()) 
            {
                followTrailTimeRemaining = TIME_FOLLOWING_TRAIL;
            }
        }
    }
}
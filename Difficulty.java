import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty extends Actor
{
     int mineNum;
    int gridRow;
   int gridColl;
   MouseInfo mouse = Greenfoot.getMouseInfo();
    int mouseX = -1;
    int mouseY = -1; 

   //GreenfootImage difficulty;
    /**
     * Act - do whatever the Difficulty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Difficulty(int m, int r, int c, String diff){
        mineNum = m;
        gridRow = r;
        gridColl = c;
        GreenfootImage difficulty = new GreenfootImage(diff + ".jpg");
        setImage(difficulty);
        difficulty.scale(90, 40);
    }
    public void act()
    {
        mouse = Greenfoot.getMouseInfo();
        if (mouse!= null) {
            mouseX = mouse.getX();
            mouseY = mouse.getY();
        
        }
        if (Greenfoot.mouseClicked(this))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
            gameWorld.addTiles(mineNum, gridRow, gridColl);
        }

    }
}

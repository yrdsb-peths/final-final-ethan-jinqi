import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectScreen extends World
{
    int mineNum = 0;
    int gridRow = 0;
    int gridColl = 0;

    /**
     * Constructor for objects of class SelectScreen.
     * 
     */
    public SelectScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void prepare(){
        mineNum = 99;
        gridRow = 15;
        gridColl = 25;
    }
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
            gameWorld.addTiles(mineNum, gridRow, gridColl);
        }
    }
    
    public int getMine(){
        return mineNum;
    }
}

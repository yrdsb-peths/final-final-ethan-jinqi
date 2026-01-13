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
        GreenfootImage background = new GreenfootImage("background.jpg");
        setBackground(background);
        Difficulty easy = new Difficulty(10, 9, 9, "easy");
        addObject(easy, 150, 80);
        Difficulty medium = new Difficulty(40, 16, 16, "medium");
        addObject(medium, 300, 80);
        Difficulty hard = new Difficulty(99, 16, 30, "hard");
        addObject(hard, 450, 80);
        Difficulty custom = new Difficulty(0, 0, 0, "custom");
        addObject(custom, 300, 200);
        prepare();
    }
    
    public void prepare(){
        mineNum = 99;
        gridRow = 15;
        gridColl = 25;
    }
    public void act(){
        
    }
    
    public int getMine(){
        return mineNum;
    }
}

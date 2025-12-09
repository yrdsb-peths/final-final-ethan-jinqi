import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiles extends Actor
{
    /**
     * Act - do whatever the Tiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int num = -1;
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootImage tiles = new GreenfootImage("tile_-1.jpg");
    GreenfootImage[] numTiles = new GreenfootImage[10];
    public Tiles(){
        setImage (tiles);
        tiles.scale(40, 40);
        for(int i = -1; i < 9; i++){
            numTiles[i] = new GreenfootImage("tile_" + num + ".jpg");
            numTiles[i].scale(40, 40);
        }
        animationTimer.mark();
    }
    
     
    public void act()
    {
        // Add your action code here.
        
        //MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.isKeyDown("left")) {
            num = 5;
            
        }
        
        animateTiles();
        
    }
    
    public void animateTiles(){
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();
        
        if (num <= 0){
            setImage(numTiles[num]);
        }
    }
}

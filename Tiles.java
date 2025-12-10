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
    int num = Greenfoot.getRandomNumber(9);
    
    //GreenfootImage tiles = new GreenfootImage("tile_9.jpg");
    GreenfootImage[] numTiles = new GreenfootImage[10];
    //SimpleTimer animationTimer = new SimpleTimer();
    public Tiles(){
        //setImage (tiles);
        //tiles.scale(40, 40);
        for(int i = 0; i < numTiles.length; i++){
            numTiles[i] = new GreenfootImage("tile_" + i + ".jpg");
            numTiles[i].scale(40, 40);
        }
        
        //animationTimer.mark();
        
        setImage (numTiles[9]);
    }
    
     
    public void act()
    {
        // Add your action code here.
        
        //MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.isKeyDown("left")) {
            
            setImage(numTiles[num]);
        }
        
        animateTiles();
        
    }
    
    public void animateTiles(){
        
        /*
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();
        
        
        if(num < 9){
            //move(1);
            setImage(numTiles[num]);
        
        }
        */
    }
}

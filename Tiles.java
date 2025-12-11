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
    int num = 0;
    
    //GreenfootImage tiles = new GreenfootImage("tile_9.jpg");
    MouseInfo mouse = Greenfoot.getMouseInfo();
    int mouseX = 0;
    int mouseY = 0; 
    int x = 0;
    int y = 0;
    boolean holdRight = false;
    boolean holdLeft = false;
    boolean flag = false;
    boolean uncovered = false;
    GreenfootImage[] numTiles = new GreenfootImage[12];
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
        mouse = Greenfoot.getMouseInfo();
        if (mouse!= null) {
            mouseX = mouse.getX();
            mouseY = mouse.getY();
        
        }
        
        //MouseInfo mouse = Greenfoot.getMouseInfo();
        
        
        if(mouseX >= getX() - 20 && mouseX <= getX() + 20 &&
            mouseY >= getY() - 20 && mouseY <= getY() + 20) {
            if (Greenfoot.isKeyDown("right") && !uncovered){
                if(!holdRight){
                    flag = !flag;
                }
                holdRight = true;
                if(flag){
                    setImage(numTiles[10]);
                }else{
                    setImage (numTiles[9]);
                }
            } else{
                holdRight = false;
                if (Greenfoot.isKeyDown("left") && !flag){
                uncovered = true;
                setImage(numTiles[num]);
                if(num == 0){
                    MyWorld world = (MyWorld) getWorld();

                    world.callSurround(x, y);
                }
            }
            }
            
        }
        
        
    }
    
    public void setNum(int number){
        num = number;
    }
    
    public void location(int row, int coll){
        x = row;
        y = coll;
    }
    
    public void checkEmpty(){
        if(!uncovered && num == 0){
            uncovered = true;
            MyWorld world = (MyWorld) getWorld();
            world.callSurround(x, y);
        } else{
            uncovered = true;
        }
        
        setImage(numTiles[num]);
    }
    
}

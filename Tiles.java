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
    int tileSize = 40;
    //GreenfootImage tiles = new GreenfootImage("tile_9.jpg");
    MouseInfo mouse = Greenfoot.getMouseInfo();
    int mouseX = -1;
    int mouseY = -1; 
    int x = 0;
    int y = 0;
    boolean firstClick = true;
    boolean holdRight = false;
    boolean holdLeft = false;
    boolean flag = false;
    boolean uncovered = false;
    GreenfootImage[] numTiles = new GreenfootImage[12];
    //SimpleTimer animationTimer = new SimpleTimer();
    public Tiles(){
        //setImage (tiles);
        //tiles.scale(40, 40);
        
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
        
        
        if(mouseX >= getX() - tileSize / 2 && mouseX <= getX() + tileSize / 2 && mouseX > -1 &&
            mouseY >= getY() - tileSize / 2 && mouseY <= getY() + tileSize / 2 && mouseY > -1) {
            
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
                    
                    if(firstClick){
                    MyWorld world = (MyWorld) getWorld();
                    world.createBombs(x, y);
                    }else{
                    MyWorld world = (MyWorld) getWorld();
                    uncovered = true;
                    setImage(numTiles[num]);
                    
                    if (num == 11) {   // 💣 BOMB CLICKED
                        world.loseGame();
                        return;
                    }
                    
                    if (num == 0) {
                        world.callSurround(x, y);
                    }
                    }
                }
            }
            
        }
        
        
    }
    public void showBomb()
    {
        uncovered = true;
        setImage(numTiles[11]);
    }
    public void setNum(int number){
        num = number;
        firstClick = false;
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
    
    public void setTileSize(int size){
        size = tileSize;
        for(int i = 0; i < numTiles.length; i++){
            numTiles[i] = new GreenfootImage("tile_" + i + ".jpg");
            numTiles[i].scale(tileSize, tileSize);
        }
        
        setImage (numTiles[9]);
    }
}

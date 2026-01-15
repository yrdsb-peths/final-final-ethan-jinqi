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
   String mode;
   MouseInfo mouse = Greenfoot.getMouseInfo();
    int mouseX = -1;
    int mouseY = -1; 
    GreenfootImage difficulty;
   //GreenfootImage difficulty;
    /**
     * Act - do whatever the Difficulty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Difficulty(int m, int r, int c, String diff){
        mineNum = m;
        gridRow = r;
        gridColl = c;
        mode = diff;
        difficulty = new GreenfootImage(diff + ".jpg");
        setImage(difficulty);
        difficulty.scale(90, 40);
    }
    public Difficulty(String diff){
        mode = diff;
        difficulty = new GreenfootImage(diff + ".jpg");
        setImage(difficulty);
        difficulty.scale(90, 40);
        
        
    }
    public void act()
    {
        mouse = Greenfoot.getMouseInfo();
        SelectScreen world = (SelectScreen) getWorld();
        if (mouse!= null) {
            mouseX = mouse.getX();
            mouseY = mouse.getY();
        
        }
        if (Greenfoot.mouseClicked(this))
        {
            

            
            if("start".equals(mode)){
                MyWorld gameWorld = new MyWorld();
                Greenfoot.setWorld(gameWorld);
                if(mineNum >= gridRow * gridColl){
                    mineNum = gridRow * gridColl - 1;
                }
                gameWorld.addTiles(mineNum, gridRow, gridColl);
            } else {
                //move(1);
                world.setMode(mineNum, gridRow, gridColl, mode);
            }
        }
        
        if(world.checkMode().equals(mode)){
            difficulty.scale(99, 44);
        } else {
            difficulty.scale(90, 40);
        }
    }
    
    public void getCustom(int m, int r, int c){
        mineNum = m;
        //move(mineNum);
        gridRow = r;
        gridColl = c;
    }
}

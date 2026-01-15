import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Modify here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Modify extends Actor
{
    /**
     * Act - do whatever the Modify wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int addNum = 0;
    MouseInfo mouse = Greenfoot.getMouseInfo();
    int mouseX = -1;
    int mouseY = -1; 
    boolean clicked = false;
    boolean keyPressed = false;
    public Modify(){
        GreenfootImage image = new GreenfootImage("modify.jpg");
        setImage(image);
        image.scale(90, 40);
    }
    public void act()
    {
        // Add your action code here.
        mouse = Greenfoot.getMouseInfo();
        if (mouse!= null) {
            mouseX = mouse.getX();
            mouseY = mouse.getY();
        
        }

        if(mouseX >= getX() - 90 / 2 && mouseX <= getX() + 90 / 2 && mouseX > -1 &&
            mouseY >= getY() - 40 / 2 && mouseY <= getY() + 40 / 2 && mouseY > -1){
            if (Greenfoot.mouseClicked(null))
            {
                if (mouse != null && mouse.getButton() == 1)
                {
                    // Your code for the left-click action goes here
                    clicked = true;
                }
            }
        } else {
            clicked = false;
        }
        if(clicked){
            if(Greenfoot.isKeyDown("0")){
            add(0);
            keyPressed = true;
            } else if(Greenfoot.isKeyDown("1")){
                add(1);
            } else if(Greenfoot.isKeyDown("2")){
                add(2);
            } else if(Greenfoot.isKeyDown("3")){
                add(3);
            } else if(Greenfoot.isKeyDown("4")){
                add(4);
            } else if(Greenfoot.isKeyDown("5")){
                add(5);
            } else if(Greenfoot.isKeyDown("6")){
                add(6);
            } else if(Greenfoot.isKeyDown("7")){
                add(7);
            } else if(Greenfoot.isKeyDown("8")){
                add(8);
            } else if(Greenfoot.isKeyDown("9")){
                add(9);
            } else{
                keyPressed = false;
            }
        }
        
        
    }
    
    public void add(int n){
        SelectScreen world = (SelectScreen) getWorld();
        if(!keyPressed && addNum < 10 ){
            addNum = addNum * 10 + n;
            
        }
        keyPressed = true;
    }
     
    public int showNum(){
        return addNum;
    }
}

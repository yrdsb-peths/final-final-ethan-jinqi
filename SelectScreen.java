import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectScreen extends World
{
    int mineNum = 10;
    int gridRow = 9;
    int gridColl = 9;
    boolean chooseMode = false;
    String mode = "easy";
    Modify mines;
    Label mNum;
    Modify rows;
    Label rNum;
    Modify colls;
    Label cNum;
    
    Label modeText;
    Difficulty custom;
    Difficulty start;
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
        custom = new Difficulty("custom");
        addObject(custom, 300, 150);
        start = new Difficulty("start");
        addObject(start, 300, 320);
        
        mines = new Modify();
        mNum = new Label("0", 50);
        
        rows = new Modify();
        rNum = new Label("0", 50);
        
        colls = new Modify();
        cNum = new Label("0", 40);
        
        modeText = new Label("Mines      Rows     Collumns", 50);
        //prepare();

    }
    
    public void prepare(){
        mineNum = 99;
        gridRow = 15;
        gridColl = 25;
    }
    
    public void act(){
        mNum.setValue(mines.showNum());
        rNum.setValue(rows.showNum());
        cNum.setValue(colls.showNum());
        
        custom.getCustom(mines.showNum(), rows.showNum(), colls.showNum());
        if (mode.equals("custom")) {
            mineNum = mines.showNum();
            gridRow = rows.showNum();
            gridColl = colls.showNum();
        }
        start.getCustom(mineNum, gridRow, gridColl);

        
        if(mode.equals("custom")){
            addObject(mines, 150, 250);
            addObject(rows, 300, 250);
            addObject(colls, 450, 250);
            
            addObject(mNum, 150, 250);
            addObject(rNum, 300, 250);
            addObject(cNum, 450, 250);
            
            addObject(modeText, 320, 200);
        } else {
            removeObject(mines);
            removeObject(rows);
            removeObject(colls);
            
            removeObject(mNum);
            removeObject(rNum);
            removeObject(cNum);
            
            removeObject(modeText);
        }
    }
    
    public int getCustom(){
        return mineNum;
    }
    
    public void setMode(int M, int R, int C, String Mode){
        mineNum = M;
        gridRow = R;
        gridColl = C;
        mode = Mode;
    }
    
    public boolean choose(){
        return chooseMode;
    }
    
    public String checkMode(){
        return mode;
    }
}

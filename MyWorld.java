import greenfoot.*;

public class MyWorld extends World {
    
   // int countTimer = 0;
   // SimpleTimer setTimer = new SimpleTimer();
    
   // Label timerLabel;
    
    int mineNum = 99;
    int tileSize = 1000 / 30;
    private final int gridRow = 16;
    private final int gridColl = 50;
    int flagCount = mineNum;
    int[][] bombs = new int[gridRow][gridColl];
    Tiles[][] tiles = new Tiles[gridRow][gridColl];
    Label flagLabel;
    boolean gameOver = false;
    private int time = 0;
    boolean firstClick = true;
    public void act()
    {
        if(!firstClick){
        time++;
        if(time % 60 == 0)
            {
                showText("Time: " + (time / 60), 520, 20);    
            }
        }
    }
    public MyWorld() {
        
        super(1000, 600, 1);
        if(1000/gridColl < 500/gridRow){
            tileSize = 1000/gridColl;
        } else {
            tileSize = 500/gridRow;
        }
        flagLabel = new Label("flag: " + flagCount,50);
      //  timerLabel = new Label(countTimer,100);
        addObject(flagLabel, 700, 30);
       // addObject(timerLabel, 950, 150);
        
        for(int i = 0; i < gridRow; i++){
            for(int n = 0; n < gridColl; n++){
                
                bombs[i][n] = 0;
            }
        }
        //creates the tiles
        
        for(int i = 0; i < gridRow; i++){
            for(int n = 0; n < gridColl; n++){
                tiles[i][n] = new Tiles();
                tiles[i][n].setTileSize(tileSize);
                //bombs[i][n] = createTiles(i, n);
                tiles[i][n].location(i, n);
                addObject (tiles[i][n], tileSize / 2 + 500 - gridColl * tileSize / 2 + tileSize * n,
                tileSize / 2 + tileSize * i + 100 + 250 - gridRow * tileSize/2 );
            }
        }
        
    }
    /*public void act(){
        changeTimer();
    }*/
    public void loseGame()
    {
        for(int i = 0; i < gridRow; i++)
        {
            for(int n = 0; n < gridColl; n++)
            {
                if(bombs[i][n] == 11)
                {
                    tiles[i][n].showBomb();    
                }
            }    
        }
        Greenfoot.stop();
    }
    /*
     * creats bombs at random location
     */
    public void createBombs(int row, int coll){
        
        /*
         * moves bomb if invalid spot
         */
       // setTimer.mark();
       firstClick = false;
        for(int i = 0; i < mineNum; i++){
            int c = Greenfoot.getRandomNumber(gridColl);
            int r = Greenfoot.getRandomNumber(gridRow);
            while(bombs[r][c] == 11 || moveBombs(row, coll, r, c)){
                c = Greenfoot.getRandomNumber(gridColl);
                r = Greenfoot.getRandomNumber(gridRow);
                
            }
            bombs[r][c] = 11;
        }
        
        for(int i = 0; i < gridRow; i++){
            for(int n = 0; n < gridColl; n++){
                tiles[i][n].setNum(createTiles(i, n));
                bombs[i][n] = createTiles(i, n);
            }
        }
        
    }
    private boolean moveBombs(int row, int coll, int r, int c){
        if (row - 1 <= r && row + 1 >= r &&
            coll - 1 <=c && coll + 1 >= c){
            return true;
        }
        return false;
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,300,200);
    }
    /*
     * returns the amount of bombs surrounding
     */
    
    public int createTiles(int row, int coll){
        int count = 0;
        if(bombs[row][coll] == 11){
            return 11;
        }
        for(int i = -1; i <= 1; i++){
            for(int n = -1; n <= 1; n++){
                if(row + n >= 0 && row + n < gridRow &&
                coll + i >= 0 && coll + i < gridColl){
                    if (bombs[row + n][coll + i] == 11){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public void callSurround(int row, int coll){
        for(int i = -1; i <= 1; i++){
            for(int n = -1; n <= 1; n++){
                if(row + n >= 0 && row + n < gridRow &&
                coll + i >= 0 && coll + i < gridColl){
                    tiles[row + n][coll + i].checkEmpty();
                }
            }
        }
    }

    public void flagChange(int add){
        flagCount += add;
        flagLabel.setValue("flag: " + flagCount);
    }
   /* public void changeTimer(){
        
        if(setTimer.millisElapsed() < 1000){
            return;
        }
        setTimer.mark();
        countTimer++;
        timerLabel.setValue(countTimer);
    }*/
}

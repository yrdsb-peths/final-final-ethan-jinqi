import greenfoot.*;

public class MyWorld extends World {
    int mineNum = 50;
    private final int tileSize = 40;
    private final int gridRow = 15;
    private final int gridColl = 25;
    int[][] bombs = new int[gridRow][gridColl];
    Tiles[][] tiles = new Tiles[gridRow][gridColl];
    public MyWorld() {
        super(1000, 600, 1);
        
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
                addObject (tiles[i][n], tileSize / 2 + tileSize * n, tileSize / 2 + tileSize * i);
            }
        }
        
    }
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
    }
    /*
     * creats bombs at random location
     */
    public void createBombs(int row, int coll){
        
        /*
         * moves bomb if invalid spot
         */
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
    public int tileSizeSend(){
        return tileSize;
    }
}

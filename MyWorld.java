import greenfoot.*;

public class MyWorld extends World {
    int mineNum = 50;
    int[][] bombs = new int[15][15];
    Tiles[][] tiles = new Tiles[15][15];
    public MyWorld() {
        super(600, 600, 1);
        
        for(int i = 0; i < 15; i++){
            for(int n = 0; n < 15; n++){
                
                bombs[i][n] = 0;
            }
        }
        //creates the tiles
        
        for(int i = 0; i < 15; i++){
            for(int n = 0; n < 15; n++){
                tiles[i][n] = new Tiles();
                //tiles[i][n].setNum(createTiles(i, n));
                //bombs[i][n] = createTiles(i, n);
                tiles[i][n].location(i, n);
                addObject (tiles[i][n], 20 + 40 * n, 20 + 40 * i);
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
            int c = Greenfoot.getRandomNumber(15);
            int r = Greenfoot.getRandomNumber(15);
            while(bombs[r][c] == 11 || moveBombs(row, coll, r, c)){
                c = Greenfoot.getRandomNumber(15);
                r = Greenfoot.getRandomNumber(15);
                
            }
            bombs[r][c] = 11;
        }
        
        for(int i = 0; i < 15; i++){
            for(int n = 0; n < 15; n++){
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
                if(row + n >= 0 && row + n < 15 &&
                coll + i >= 0 && coll + i < 15){
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
                if(row + n >= 0 && row + n < 15 &&
                coll + i >= 0 && coll + i < 15){
                    tiles[row + n][coll + i].checkEmpty();
                }
            }
        }
    }
}

import greenfoot.*;

public class MyWorld extends World {
    static int mineNum = 50;
    static int[][] bombs = new int[15][15];
    Tiles[][] tiles = new Tiles[15][15];
    public MyWorld() {
        super(600, 600, 1);
        /*
         * creats bombs at random location
         */
        for(int i = 0; i < 15; i++){
            for(int n = 0; n < 15; n++){
                bombs[i][n] = 0;
            }
        }
        /*
         * moves bomb if invalid spot
         */
        for(int i = 0; i < mineNum; i++){
            int coll = Greenfoot.getRandomNumber(15);
            int row = Greenfoot.getRandomNumber(15);
            while(bombs[row][coll] == 11){
                coll = Greenfoot.getRandomNumber(15);
                row = Greenfoot.getRandomNumber(15);
            }
            bombs[row][coll] = 11;
        }
        
        //creates the tiles
        
        for(int i = 0; i < 15; i++){
            for(int n = 0; n < 15; n++){
                tiles[i][n] = new Tiles();
                tiles[i][n].setNum(createTiles(i, n));
                bombs[i][n] = createTiles(i, n);
                tiles[i][n].location(i, n);
                addObject (tiles[i][n], 20 + 40 * n, 20 + 40 * i);
            }
        }
        
    }
    
    /*
     * returns the amount of bombs surrounding
     */
    
    public static int createTiles(int row, int coll){
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

import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 600, 1);
        
        Tiles[][] tiles = new Tiles[15][15];
        for(int i = 0; i < 15; i++){
            for(int n = 0; n < 15; n++){
                tiles[i][n] = new Tiles();
                addObject (tiles[i][n], 20 + 40 * n, 20 + 40 * i);
            }
        }
        
    }
}

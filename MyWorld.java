import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        Tiles tiles = new Tiles();
        addObject (tiles, 100, 100);
    }
}

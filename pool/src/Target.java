//represents the target objects in the game

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Target implements GameObject {

    private int x, y;
    private static final int SIZE = 30;

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, SIZE, SIZE);
    }

    @Override
    public boolean isClicked(int x, int y) {
        return new Ellipse2D.Double(this.x, this.y, SIZE, SIZE).contains(x, y);
    }
}

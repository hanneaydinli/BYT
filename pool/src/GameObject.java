//defines the behaviors of game objects



import java.awt.*;

public interface GameObject {
    void setPosition(int x, int y);
    void draw(Graphics g);
    boolean isClicked(int x, int y);
}

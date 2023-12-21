//creates the main window of the game and manages the game

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ObjectPoolGame extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private GameObjectPool gameObjectPool;
    private List<GameObject> activeGameObjects;

    private int score;

    public ObjectPoolGame() {
        setTitle("Object Pool Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Object pool initialization
        gameObjectPool = new GameObjectPool(10);
        activeGameObjects = new ArrayList<>();

        // Mouse listener for shooting targets
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                handleClick(e.getX(), e.getY());
            }
        });

        score = 0;
        setVisible(true);
    }

    private void handleClick(int x, int y) {
        for (GameObject gameObject : new ArrayList<>(activeGameObjects)) {
            if (gameObject.isClicked(x, y)) {
                activeGameObjects.remove(gameObject);
                gameObjectPool.releaseObject(gameObject);
                score++;
                repaint();
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (GameObject gameObject : activeGameObjects) {
            gameObject.draw(g);
        }
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
    }

    private void startGame() {
        Timer timer = new Timer(1000, e -> {
            GameObject target = gameObjectPool.acquireObject();
            if (target != null) {
                target.setPosition(getRandomX(), getRandomY());
                activeGameObjects.add(target);
                repaint();
            }
        });
        timer.start();
    }

    private int getRandomX() {
        return (int) (Math.random() * (WIDTH - 50));
    }

    private int getRandomY() {
        return (int) (Math.random() * (HEIGHT - 50));
    }

    public static void main(String[] args) {
        ObjectPoolGame game = new ObjectPoolGame();
        game.startGame();
    }
}

//manages a pool of GameObjects

import java.util.ArrayList;
import java.util.List;

public class GameObjectPool {

    private final int maxSize;
    private final List<GameObject> pool;

    public GameObjectPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new ArrayList<>();
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxSize; i++) {
            pool.add(new Target());
        }
    }

    public GameObject acquireObject() {
        if (!pool.isEmpty()) {
            return pool.remove(0);
        } else {
            return null;
        }
    }

    public void releaseObject(GameObject object) {
        if (pool.size() < maxSize) {
            pool.add(object);
        }
    }
}

package vacuumcleaner;

import java.util.Random;

public class World {
    private static Random random = new Random();
    
    private int n, m;
    private int[][] world;

    private final int SPIDER_SIZE = 4;
    
    public World(int n, int m) throws IllegalArgumentException {
        if (n < 6 || m < 6) {
            throw new IllegalArgumentException("Размеры комнаты должны быть больше 6 метров!");
        }
        this.n = n;
        this.m = m;
        
        world = new int[n][m];
        createBorders();
        createObstacles();
        createGarbage();
    }
    
    private void createBorders() {
        //vertical
        for (int i = 0; i < n; i++) {
            world[i][0] = 1;
            world[i][m - 1] = 1;
        }
        //horizontal
        for (int i = 0; i < m; i++) {
            world[0][i] = 1;
            world[n - 1][i] = 1;
        }
    }
    
    private void createObstacles() {
        for (int i = 0; i < n * m / 15; i++) {
            SpriderFormObstacle.createObstacle(
                1 + random.nextInt(n - 2), 1 + random.nextInt(m - 2), 
                random.nextInt(SPIDER_SIZE), random.nextInt(SPIDER_SIZE), 
                random.nextInt(SPIDER_SIZE), random.nextInt(SPIDER_SIZE), 
                n, m, world);
        }
    }
    
    private void createGarbage() {
        int garbageCount = 5 + random.nextInt(n * m / 2);
        for (int i = 0; i < garbageCount; i++) {
            int y = 1 + random.nextInt(n - 2);
            int x = 1 + random.nextInt(m - 2);
            if (isCorrect(y, x, n, m, world)) {
                world[y][x] = 2;
            }
        }
    }
    
    public Cleaner createCleaner() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (world[i][j] == 0 || world[i][j] == 2) {
                    world[i][j] = 8;
                    return new Cleaner(i, j, world, n * m / 2);
                }
            }
        }
        return null;
    }
    
    public static boolean isCorrect(int y, int x, int n, int m, int[][] world) {
        return x >= 0 && x < m && y >= 0 && y < n && world[y][x] == 0;
    }
    
    public void print() {
        System.out.println(n + "x" + m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(world[i][j]);
            }
            System.out.println();
        }
    }
    
}

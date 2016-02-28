package vacuumcleaner;

import java.util.Random;

public class Cleaner {

    private static Random rand = new Random();
    private int y, x, n, m;
    private int[][] world;
    private int[][] history;
    private int strange;
    private int strangenessDegree;
    public int score;

    private final int REMUNERATION = 10;
    private final int FINE = 1;
    private final int LIFE = 1000;
    

    public Cleaner(int y, int x, int[][] world, int strangenessDegree) {
        this.y = y;
        this.x = x;
        this.world = world;
        this.strangenessDegree = strangenessDegree;
        world[y][x] = 8;
        history = new int[1000][1000];
        history[y][x] = 8;
        strange = 0;
        
    }

    public void clean(World thisWorld) {
        thisWorld.print();

        for (int time = 0; time < LIFE; time++) {
            if (strange > strangenessDegree) {
                break;
            }
            
            Action[] actions = Action.values();
            Action action;
            if (world[y][x] == 2) {
                action = actions[5];
            } else {
                action = actions[rand.nextInt(5)];
            }
            switch (action) {
                case UP:
                    if (world[y - 1][x] != 1) {
                        if (history[y - 1][x] == 8) {
                            int random = rand.nextInt(2);
                            if (random == 0) {
                                thisWorld.print();
                                System.out.println("I stay in place. My score is: " + score);
                                System.out.println();
                                break;
                            } else {
                                strange++;
                            }
                        }
                        world[y][x] = 0;
                        history[y][x] = 8;

                        y--;
                        if (world[y][x] == 0) {
                            world[y][x] = 8;
                        }

                        score -= FINE;
                        thisWorld.print();
                        System.out.println("I go up. My score is: " + score);
                        System.out.println();
                    }
                    break;
                    
                case DOWN:
                    if (world[y + 1][x] != 1) {
                        if (history[y + 1][x] == 8) {
                            int random = rand.nextInt(2);
                            if (random == 0) {
                                thisWorld.print();
                                System.out.println("I stay in place. My score is: " + score);
                                System.out.println();
                                break;
                            } else {
                                strange++;
                            }
                        }
                        world[y][x] = 0;
                        history[y][x] = 8;

                        y++;
                        if (world[y][x] == 0) {
                            world[y][x] = 8;
                        }

                        score -= FINE;
                        thisWorld.print();
                        System.out.println("I go down. My score is: " + score);
                        System.out.println();
                    }
                    break;

                case LEFT:
                    if (world[y][x - 1] != 1) {
                        if (history[y][x - 1] == 8) {
                            int random = rand.nextInt(2);
                            if (random == 0) {
                                thisWorld.print();
                                System.out.println("I stay in place. My score is: " + score);
                                System.out.println();
                                break;
                            } else {
                                strange++;
                            }
                        }
                        world[y][x] = 0;
                        history[y][x] = 8;

                        x--;
                        if (world[y][x] == 0) {
                            world[y][x] = 8;
                        }

                        score -= FINE;
                        thisWorld.print();
                        System.out.println("I go left. My score is: " + score);
                        System.out.println();
                    }
                    break;
                    
                case RIGHT:
                    if (world[y][x + 1] != 1) {
                        if (history[y][x + 1] == 8) {
                            int random = rand.nextInt(2);
                            if (random == 0) {
                                thisWorld.print();
                                System.out.println("I stay in place. My score is: " + score);
                                System.out.println();
                                break;
                            } else {
                                strange++;
                            }
                        }
                        world[y][x] = 0;
                        history[y][x] = 8;

                        x++;
                        if (world[y][x] == 0) {
                            world[y][x] = 8;
                        }

                        score -= FINE;
                        thisWorld.print();
                        System.out.println("I go right. My score is: " + score);
                        System.out.println();
                    }
                    break;
                    
                case SUCK:
                    world[y][x] = 8;
                    score += REMUNERATION;
                    thisWorld.print();
                    System.out.println("I suck. My score is: " + score);
                    System.out.println();
                    break;
                case SLEEP:
                    thisWorld.print();
                    System.out.println("I sleep. My score is: " + score);
                    System.out.println();
                    break;

            }
        }
    }
}

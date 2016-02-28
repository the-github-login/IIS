package vacuumcleaner;

public class SpriderFormObstacle {
    
    
    public static void createObstacle(int yCenter, int xCenter, 
                                      int upSize, int downSize, 
                                      int leftSize, int rightSize,
                                      int n, int m, int[][] world) {
        // down
        int i = yCenter; 
        while (i < yCenter + downSize) {
            if (World.isCorrect(i, xCenter, n, m, world)) {
                world[i][xCenter] = 1;
            }
            else break;
            i++;
        }
        
        //up
        i = yCenter - 1; 
        while (i > yCenter - upSize) {
            if (World.isCorrect(i, xCenter, n, m, world)) {
                world[i][xCenter] = 1;
            }
            else break;
            i--;
        }
        
        //right
        int j = xCenter + 1; 
        while (j < xCenter + rightSize) {
            if (World.isCorrect(yCenter, j, n, m, world)) {
                world[yCenter][j] = 1;
            }
            else break;
            j++;
        }
        
        //left
        j = xCenter - 1; 
        while (j > xCenter - leftSize) {
            if (World.isCorrect(yCenter, j, n, m, world)) {
                world[yCenter][j] = 1;
            }
            else break;
            j--;
        }
    }
    
    
}

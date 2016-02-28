/**
 * 0 - floor
 * 1 - wall and another obstacles
 * 2 - the garbage
 * 8 - vacuum cleaner
 */
package vacuumcleaner;

public class VacuumCleaner {

    public static void main(String[] args) {
        try {
            World world = new World(7, 10);
            Cleaner cleaner = world.createCleaner();
            cleaner.clean(world);
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

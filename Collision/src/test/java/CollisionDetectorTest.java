import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.collision.Collision;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CollisionDetectorTest {
    private Collision collision = new Collision();
    @Test
    public void TestEntityCollision() {
        Entity Asteroid = new Entity();
        Entity Bullet = new Entity();

        Asteroid.setX(100);
        Asteroid.setY(100);
        Asteroid.setPolygonCoordinates(20, 0, 14, 14, 0, 20, -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);

        Bullet.setX(101);
        Bullet.setY(101);
        Bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
        assertTrue(collision.isColliding(Asteroid, Bullet), "Entities should collide");
    }
    @Test
    public void TestEntityCollision2() {
        Entity Asteroid = new Entity();
        Entity Bullet = new Entity();

        Asteroid.setX(100);
        Asteroid.setY(100);
        Asteroid.setPolygonCoordinates(20, 0, 14, 14, 0, 20, -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);

        Bullet.setX(200);
        Bullet.setY(200);
        Bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
        assertFalse(collision.isColliding(Asteroid, Bullet), "Entities should not collide");
    }
}

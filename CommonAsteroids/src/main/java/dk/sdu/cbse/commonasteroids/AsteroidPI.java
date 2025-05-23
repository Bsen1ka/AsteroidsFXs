package dk.sdu.cbse.commonasteroids;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.Entity;

public interface AsteroidPI {
    void createAsteroids(Entity entity, World world);
    boolean isAsteroid(Entity entity);
    void splitAsteroid(Entity asteroid, GameData gameData, World world);
}

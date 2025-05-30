package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGameService;

import java.util.Random;

public class NewAsteroids implements IGameService {

    private Entity asteroid;
    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroids(gameData, world);
        world.addEntity(asteroid);
    }

    private Entity createAsteroids(GameData gameData, World world) {
        Entity asteroid = new Asteroid();
        Random rnd = new Random();
        int size = rnd.nextInt(10) + 5;
        asteroid.setPolygonCoordinates(20, 0, 14, 14, 0, 20,
                -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);
        asteroid.setX(0);
        asteroid.setY(0);
        asteroid.setRadius(size);
        asteroid.setRotation(rnd.nextInt(90));
        asteroid.setData("type", "asteroid");
        asteroid.setData("size", 3);
        asteroid.setLife(10);
        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }
}

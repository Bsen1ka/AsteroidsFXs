package dk.sdu.cbse.asteroids;


import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.commonasteroids.AsteroidPI;

public class AsteroidsSplit implements AsteroidPI {
    @Override
    public void createAsteroids(Entity entity, World world) {
    }

    @Override
    public boolean isAsteroid(Entity entity) {
        return "asteroid".equals(entity.getData("type"));
    }

    @Override
    public void splitAsteroid(Entity asteroid, GameData gameData, World world) {
        Integer size = (Integer) asteroid.getData("size");
        if (size == null || size < 1) {
            world.removeEntity(asteroid);
            return;
        }
        for (int i = 0; i < 2; i++) {
            Entity smallAsteroid = new Asteroid();
            smallAsteroid.setX(asteroid.getX() + Math.random() * 10 - 5);
            smallAsteroid.setY(asteroid.getY() + Math.random() * 10 - 5);
            smallAsteroid.setRotation(Math.random() * 360);
            smallAsteroid.setRadius(asteroid.getRadius() * 0.6f);
            smallAsteroid.setPolygonCoordinates(asteroid.getPolygonCoordinates());
            smallAsteroid.setData("type", "asteroid");
            smallAsteroid.setData("size", size - 1);

            world.addEntity(smallAsteroid);
        }

        world.removeEntity(asteroid);
    }
}

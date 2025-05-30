package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityService;

public class AsteroidsControl implements IEntityService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);

            if (asteroid.getX() < 0) {
                asteroid.setX(asteroid.getX() - gameData.getDisplayWidth());
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(asteroid.getX() % gameData.getDisplayWidth());
            }

            if (asteroid.getY() < 0) {
                asteroid.setY(asteroid.getY() - gameData.getDisplayHeight());
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(asteroid.getY() % gameData.getDisplayHeight());
            }
            if (asteroid.getLife() == 8 ) {
                splitAsteroid(asteroid,world);
            }
            if (asteroid.getLife() == 4 ){
                splitAsteroid(asteroid,world);
            }
            if (asteroid.getLife() <= 0 ){
                world.removeEntity(asteroid);
            }
        }
    }

    public void splitAsteroid(Entity asteroid, World world) {
        Integer size = (Integer) asteroid.getData("size");
        for (int i = 0; i < 2; i++) {
            Entity smallAsteroid = new Asteroid();;
            smallAsteroid.setX(asteroid.getX() + Math.random() * 10 - 5);
            smallAsteroid.setY(asteroid.getY() + Math.random() * 10 - 5);
            smallAsteroid.setRotation(Math.random() * 360);
            smallAsteroid.setRadius(asteroid.getRadius() -10);
            if(asteroid.getLife() == 8){
                smallAsteroid.setPolygonCoordinates(14, 0, 8, 8, 0, 14,
                        -8, 8, -14, 0, -8, -8, 0, -14, 8, -8);
            }else {
                smallAsteroid.setPolygonCoordinates(10, 0, 4, 4, 0, 10,
                        -4, 4, -10, 0, -4, -4, 0, -10, 4, -4);
            }

            smallAsteroid.setData("type", "asteroid");
            smallAsteroid.setData("size", size - 1);
            smallAsteroid.setLife(asteroid.getLife() - 1);
            world.addEntity(smallAsteroid);
        }

        world.removeEntity(asteroid);
    }
}

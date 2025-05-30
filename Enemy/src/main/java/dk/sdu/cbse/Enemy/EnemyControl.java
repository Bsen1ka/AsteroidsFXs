package dk.sdu.cbse.Enemy;

import dk.sdu.cbse.bullets.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityService;


import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class EnemyControl implements IEntityService {
    @Override
    public void process(GameData gameData, World world) {
        Random random = new Random();

        for (Entity enemy : world.getEntities(Enemy.class)) {

            if (random.nextInt(100) < 5) {
                enemy.setRotation(enemy.getRotation() + (random.nextBoolean() ? 10 : -10));
            }


            if (random.nextInt(100) < 30) {
                double changeX = Math.cos(Math.toRadians(enemy.getRotation())) * 2;
                double changeY = Math.sin(Math.toRadians(enemy.getRotation())) * 2;
                enemy.setX(enemy.getX() + changeX);
                enemy.setY(enemy.getY() + changeY);
            }


            if (random.nextInt(100) < 3) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> world.addEntity(spi.createBullet(enemy, gameData))
                );
            }

            // Keep enemy inside screen boundaries
            if (enemy.getX() < 0) {
                enemy.setX(1);
            }
            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(gameData.getDisplayWidth() - 1);
            }
            if (enemy.getY() < 0) {
                enemy.setY(1);
            }
            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(gameData.getDisplayHeight() - 1);
            }
            if(enemy.getLife() <= 0 ){
                world.removeEntity(enemy);
            }
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}

package dk.sdu.cbse.player;


import dk.sdu.cbse.bullets.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class PlayerControl implements IEntityService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity playerShip : world.getEntities(Player.class)) {


            if (gameData.getKeys().isDown(GameKeys.LEFT)){
                playerShip.setRotation(playerShip.getRotation() - 5);
            }
            if (gameData.getKeys().isDown(GameKeys.RIGHT)){
                playerShip.setRotation(playerShip.getRotation() + 5);
            }
            if (gameData.getKeys().isDown(GameKeys.UP)){
                double changeX = Math.cos(Math.toRadians(playerShip.getRotation()));
                double changeY = Math.sin(Math.toRadians(playerShip.getRotation()));
                playerShip.setX(playerShip.getX() + changeX);
                playerShip.setY(playerShip.getY() + changeY);
            }
            if (gameData.getKeys().isPressed(GameKeys.SPACE)){
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(playerShip, gameData));}
                );
            }

            if (playerShip.getX() < 0){
                playerShip.setX(1);
            }
            if (playerShip.getY() < 0){
                playerShip.setY(1);
            }
            if (playerShip.getX() > gameData.getDisplayWidth()){
                playerShip.setX(gameData.getDisplayWidth());
            }
            if (playerShip.getY() > gameData.getDisplayHeight()){
                playerShip.setY(gameData.getDisplayHeight());
            }
            if (playerShip.getLife() <= 0){
                world.removeEntity(playerShip);
            }
        }
    }
    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}

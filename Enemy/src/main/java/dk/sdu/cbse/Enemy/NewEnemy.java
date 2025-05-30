package dk.sdu.cbse.Enemy;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGameService;


public class NewEnemy implements IGameService {
    private Entity enemy;
    @Override
    public void start(GameData gameData, World world) {
            enemy = createEnemy(gameData);
            world.addEntity(enemy);
    }

    private Entity createEnemy(GameData gameData) {
        Entity enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-8,-8,8,0,-8,8);
        enemyShip.setX((double) gameData.getDisplayWidth() / 4);
        enemyShip.setY((double) gameData.getDisplayHeight() / 4);
        enemyShip.setRadius(8);
        enemyShip.setData("type", "enemy");
        enemyShip.setLife(3);
        return enemyShip;
    }
    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}

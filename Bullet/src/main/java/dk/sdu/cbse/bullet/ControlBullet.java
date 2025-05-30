package dk.sdu.cbse.bullet;

import dk.sdu.cbse.bullets.Bullet;
import dk.sdu.cbse.bullets.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityService;
import dk.sdu.cbse.common.services.IGameService;

public class ControlBullet implements IEntityService, BulletSPI {

    @Override
    public Entity createBullet(Entity entity, GameData gameData) {
        Entity bullet = new Bullet();
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);

        double changeX = Math.cos(Math.toRadians(entity.getRotation()));
        double changeY = Math.sin(Math.toRadians(entity.getRotation()));
        bullet.setX(entity.getX() + changeX * 10);
        bullet.setY(entity.getY() + changeY * 10);
        bullet.setRotation(entity.getRotation());
        bullet.setRadius(1);
        bullet.setLife(1);
        bullet.setData("type", "bullet");
        return bullet;
    }

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(entity.getRotation()));
            double changeY = Math.sin(Math.toRadians(entity.getRotation()));
            entity.setX(entity.getX() + changeX * 3);
            entity.setY(entity.getY() + changeY * 3);
            if (entity.getX() < 0 ){
                world.removeEntity(entity);
            }
            if (entity.getY() < 0 ){
                world.removeEntity(entity);
            }
            if (entity.getX() > gameData.getDisplayWidth() + 100){
                world.removeEntity(entity);
            }
            if (entity.getY() > gameData.getDisplayHeight() + 100){
                world.removeEntity(entity);
            }
            if(entity.getLife() <= 0){
                world.removeEntity(entity);
            }
        }

    }
}

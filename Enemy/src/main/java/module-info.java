import dk.sdu.cbse.common.services.IEntityService;
import dk.sdu.cbse.common.services.IGameService;

module Enemy {
    requires dk.sdu.cbse.common;
    requires CommonBullet;
    uses dk.sdu.cbse.bullets.BulletSPI;
    provides IGameService with dk.sdu.cbse.Enemy.NewEnemy;
    provides IEntityService with dk.sdu.cbse.Enemy.EnemyControl;
}
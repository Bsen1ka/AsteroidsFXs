import dk.sdu.cbse.bullets.BulletSPI;
import dk.sdu.cbse.common.services.IEntityService;
import dk.sdu.cbse.common.services.IGameService;

module dk.sdu.cbse.bulletsystem {
    requires CommonBullet;
    requires dk.sdu.cbse.common;
    provides IGameService with dk.sdu.cbse.bullet.BulletSystem;
    provides IEntityService with dk.sdu.cbse.bullet.ControlBullet;
    provides BulletSPI with dk.sdu.cbse.bullet.ControlBullet;
}

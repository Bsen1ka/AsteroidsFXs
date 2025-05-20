import dk.sdu.cbse.common.services.IEntityService;
import dk.sdu.cbse.common.services.IGameService;

module dk.sdu.cbse.playersystem {
    requires dk.sdu.cbse.common;
    requires CommonBullet;
    uses dk.sdu.cbse.bullets.BulletSPI;
    provides IGameService with dk.sdu.cbse.player.NewPlayer;
    provides IEntityService with dk.sdu.cbse.player.PlayerControl;
}

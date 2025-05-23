import dk.sdu.cbse.asteroids.AsteroidsControl;
import dk.sdu.cbse.asteroids.NewAsteroids;
import dk.sdu.cbse.common.services.IEntityService;
import dk.sdu.cbse.common.services.IGameService;

module dk.sdu.cbse.asteroids.NewAsteroids {
    requires dk.sdu.cbse.common;
    requires CommonAsteroids;
    provides IGameService with NewAsteroids;
    provides IEntityService with AsteroidsControl;
    provides dk.sdu.cbse.commonasteroids.AsteroidPI
            with dk.sdu.cbse.asteroids.AsteroidsSplit;
}
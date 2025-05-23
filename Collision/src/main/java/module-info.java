import dk.sdu.cbse.common.services.IPostService;
import dk.sdu.cbse.commonasteroids.AsteroidPI;

module Collision {
    requires CommonAsteroids;
    requires dk.sdu.cbse.common;
    uses dk.sdu.cbse.commonasteroids.AsteroidPI;
    provides IPostService with dk.sdu.cbse.collision.Collision;
}
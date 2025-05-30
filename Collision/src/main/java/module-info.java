import dk.sdu.cbse.common.services.IPostService;
module Collision {
    requires dk.sdu.cbse.common;
    provides IPostService with dk.sdu.cbse.collision.Collision;
}
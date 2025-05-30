package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostService;

import static java.lang.Math.sqrt;

public class Collision implements IPostService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity e1 : world.getEntities()) {
            for (Entity e2 : world.getEntities()) {
                if (isCollision(e1, e2) && e1.getClass() != e2.getClass()) {
                    e1.decreaseLife(1);
                }
            }
        }

    }


    public boolean isCollision(Entity e1, Entity e2) {
        double x1 = e1.getX();
        double y1 = e1.getY();

        double x2 = e2.getX();
        double y2 = e2.getY();

        double result = sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
        double e1Width = e1.getWidth() / 2;
        double e2Width = e2.getWidth() / 2;

        if (result < e1Width + e2Width) {
            return true;
        }

        return false;
    }

}

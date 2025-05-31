package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostService;
import dk.sdu.cbse.common.services.ScoreService;

import static java.lang.Math.sqrt;

public class Collision implements IPostService {

    private int score = 0;
    boolean collisionHappened = false;
    @Override
    public void process(GameData gameData, World world) {


        for (Entity e1 : world.getEntities()) {
            for (Entity e2 : world.getEntities()) {
                if (isCollision(e1, e2) && e1.getClass() != e2.getClass()) {
                    e1.decreaseLife(1);
                    if(e1.getLife() == 0){
                        if("asteroid".equals(e1.getData("type"))) {
                            collisionHappened = true;
                        }
                    }
                }
            }
        }

        if (collisionHappened) {
            score = ScoreService.sendScore(1);
            collisionHappened = false;
        }

        gameData.getLabels().clear();
        gameData.addLabel("Score: " + score);
    }

    public boolean isCollision(Entity e1, Entity e2) {
        double x1 = e1.getX();
        double y1 = e1.getY();
        double x2 = e2.getX();
        double y2 = e2.getY();
        double result = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return result < (e1.getWidth() + e2.getWidth()) / 2;
    }
}

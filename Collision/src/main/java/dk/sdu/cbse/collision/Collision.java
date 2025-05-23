package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostService;
import dk.sdu.cbse.commonasteroids.AsteroidPI;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Collision implements IPostService {
    private Collection<? extends AsteroidPI> asteroidSplitters() {
        return ServiceLoader.load(AsteroidPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
    @Override
    public void process(GameData gameData, World world) {
        List<Entity> toRemove = new ArrayList<>();

        for (Entity e1 : world.getEntities()) {
            for (Entity e2 : world.getEntities()) {
                if (e1.getID().equals(e2.getID()) || e1.getData("type").equals(e2.getData("type"))) {
                }else {

                    if (collides(e1, e2)) {
                        String type1 = (String) e1.getData("type");
                        String type2 = (String) e2.getData("type");


                        if (("asteroid".equals(type2) && "bullet".equals(type1)) || ("asteroid".equals(type2) && "player".equals(type1))) {
                            handleAsteroidHit(e2, gameData, world);
                            toRemove.add(e1);
                        } else if (("asteroid".equals(type1) && "bullet".equals(type2)) || ("asteroid".equals(type1) && "player".equals(type2))) {
                            handleAsteroidHit(e1, gameData, world);
                            toRemove.add(e2);
                        } else {
                            toRemove.add(e1);
                            toRemove.add(e2);
                        }
                    }
                }
            }
        }

        for (Entity e : toRemove) {
            world.removeEntity(e);
        }
    }

    private void handleAsteroidHit(Entity asteroid, GameData gameData, World world) {
        for (AsteroidPI splitter : asteroidSplitters()) {
            if (splitter.isAsteroid(asteroid)) {
                splitter.splitAsteroid(asteroid, gameData, world);
                return;
            }
        }
    }

    private boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }


}

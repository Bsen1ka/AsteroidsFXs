package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityService;

public class EntityProces implements IEntityService {
    @Override
    public void process(GameData gameData, World world) {
        System.out.println("I am Asteroid Entity");
    }
}

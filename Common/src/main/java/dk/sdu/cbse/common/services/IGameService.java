package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IGameService {
    void start(GameData gameData, World world);
    void stop(GameData gameData, World world);
}

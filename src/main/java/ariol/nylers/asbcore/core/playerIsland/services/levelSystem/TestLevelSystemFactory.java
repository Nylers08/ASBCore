package ariol.nylers.asbcore.core.playerIsland.services.levelSystem;

import ariol.nylers.asbcore.core.playerIsland.pojo.levelSystem.LevelSystem;

public class TestLevelSystemFactory implements LevelSystemFactory{
    @Override
    public LevelSystem create() {
        return new LevelSystem();
    }
}

package ariol.nylers.asbcore.core.playerIsland.services.island.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.IslandSettings;

public class TestIslandSettingsFactory implements IslandSettingsFactory{

    @Override
    public IslandSettings create() {
        IslandSettings settings = new IslandSettings();
        settings.setRadius(50);
        return settings;
    }
}

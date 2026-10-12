package ariol.nylers.asbcore.core.playerIsland.services.region.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.IslandSettings;
import ariol.nylers.asbcore.core.playerIsland.pojo.region.IslandRegion;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;

public class BaseIslandRegionFactory implements IslandRegionFactory<IslandSettings> {

    @Override
    public IslandRegion create(IslandSettings settings) {
        double offset = settings.getRadius();
        IslandLocalLocation minPos = new IslandLocalLocation(-offset, 999, -offset);
        IslandLocalLocation maxPos = new IslandLocalLocation(offset, 999, offset);

        return new IslandRegion(minPos, maxPos);
    }
}

package ariol.nylers.asbcore.core.playerIsland.services.region.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.region.IslandRegion;

public interface IslandRegionFactory<CreateContext> {

    IslandRegion create(CreateContext createContext);
}

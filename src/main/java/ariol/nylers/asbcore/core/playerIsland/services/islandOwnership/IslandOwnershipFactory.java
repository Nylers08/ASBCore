package ariol.nylers.asbcore.core.playerIsland.services.islandOwnership;

import ariol.nylers.asbcore.core.playerIsland.pojo.IslandOwnership;

public interface IslandOwnershipFactory<CreateContext>{

    IslandOwnership create(CreateContext createContext);
}

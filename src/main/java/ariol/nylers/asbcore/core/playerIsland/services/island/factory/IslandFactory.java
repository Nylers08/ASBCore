package ariol.nylers.asbcore.core.playerIsland.services.island.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;

public interface IslandFactory<CreateContext>{

    Island create(CreateContext createContext);
}

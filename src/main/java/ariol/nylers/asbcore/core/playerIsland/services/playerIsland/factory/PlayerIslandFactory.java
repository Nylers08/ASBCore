package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;

public interface PlayerIslandFactory<CreateContext> {

    PlayerIsland create(CreateContext createContext);
}

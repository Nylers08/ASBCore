package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;

public interface PlayerIslandCreator<CreateContext> {

    PlayerIsland create(CreateContext createContext);
}

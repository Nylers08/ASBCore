package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandCacheController;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory.PlayerIslandFactoryContext;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory.PlayerIslandFactory;

public class PlayerIslandCreatorByProfileId implements PlayerIslandCreator<PlayerIslandFactoryContext>{

    private final PlayerIslandFactory<PlayerIslandFactoryContext> factory;
    private final PlayerIslandCacheController cacheController;

    public PlayerIslandCreatorByProfileId(PlayerIslandFactory<PlayerIslandFactoryContext> factory, PlayerIslandCacheController cacheController) {
        this.factory = factory;
        this.cacheController = cacheController;
    }

    @Override
    public PlayerIsland create(PlayerIslandFactoryContext context) {
        PlayerIsland playerIsland = factory.create(context);
        cacheController.cache(playerIsland);
        return playerIsland;
    }
}

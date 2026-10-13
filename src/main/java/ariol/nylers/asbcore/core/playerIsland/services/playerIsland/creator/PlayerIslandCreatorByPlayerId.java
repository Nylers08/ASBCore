package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory.PlayerIslandFactoryContext;
import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;

import java.util.UUID;

public class PlayerIslandCreatorByPlayerId implements PlayerIslandCreator<PlayerIslandCreateContext>{

    private final PlayerIslandCreatorByProfileId islandCreator;
    private final SelectedMetaProfileRegistry selectedMetaProfileRegistry;

    public PlayerIslandCreatorByPlayerId(PlayerIslandCreatorByProfileId islandCreator,
                                         SelectedMetaProfileRegistry selectedMetaProfileRegistry) {
        this.islandCreator = islandCreator;
        this.selectedMetaProfileRegistry = selectedMetaProfileRegistry;
    }

    @Override
    public PlayerIsland create(PlayerIslandCreateContext createContext) {
        MetaProfile selectedProfile = selectedMetaProfileRegistry.getSelectedProfileMetaData(createContext.getPlayerId());
        PlayerIslandFactoryContext factoryContext = new PlayerIslandFactoryContext(selectedProfile.getProfileId(), createContext.getPreset());
        return islandCreator.create(factoryContext);
    }
}

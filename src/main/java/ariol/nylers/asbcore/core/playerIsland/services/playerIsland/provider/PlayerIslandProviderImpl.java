package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.provider;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandCache;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandCacheController;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.ProfilePlayerIslandRegistry;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.db.PlayerIslandRepository;
import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;

import java.util.Optional;

public class PlayerIslandProviderImpl implements PlayerIslandProvider{

    private final PlayerIslandCacheController cacheController;
    private final PlayerIslandRepository repository;

    public PlayerIslandProviderImpl(PlayerIslandCacheController cacheController, PlayerIslandRepository repository) {
        this.cacheController = cacheController;
        this.repository = repository;
    }

    @Override
    public Optional<PlayerIsland> get(PlayerIslandId playerIslandId) {
        PlayerIsland playerIsland = cacheController.get(playerIslandId);
        if(playerIsland != null){
            return Optional.of(playerIsland);
        }

        Optional<PlayerIsland> optPlayerIsland = repository.find(playerIslandId);
        optPlayerIsland.ifPresent(cacheController::cache);

        return optPlayerIsland;
    }

    @Override
    public Optional<PlayerIsland> getByProfileId(ProfileId profileId) {
        PlayerIsland playerIsland = cacheController.getByProfileId(profileId);
        if(playerIsland != null){
            return Optional.of(playerIsland);
        }

        Optional<PlayerIsland> optPlayerIsland = repository.findByProfileId(profileId);
        optPlayerIsland.ifPresent(cacheController::cache);

        return optPlayerIsland;
    }

}

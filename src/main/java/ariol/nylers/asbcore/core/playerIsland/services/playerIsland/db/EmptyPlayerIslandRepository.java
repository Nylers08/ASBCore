package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.db;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Optional;

public class EmptyPlayerIslandRepository implements PlayerIslandRepository{
    @Override
    public Optional<PlayerIsland> find(PlayerIslandId playerIslandId) {
        return Optional.empty();
    }

    @Override
    public Optional<PlayerIsland> findByProfileId(ProfileId profileId) {
        return Optional.empty();
    }

    @Override
    public void delete(PlayerIslandId playerIslandId) {

    }
}

package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.db;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Optional;

public interface PlayerIslandRepository {

    Optional<PlayerIsland> find(PlayerIslandId playerIslandId);
    Optional<PlayerIsland> findByProfileId(ProfileId profileId);

    void delete(PlayerIslandId playerIslandId);
}

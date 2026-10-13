package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.provider;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Optional;

public interface PlayerIslandProvider {

    Optional<PlayerIsland> get(PlayerIslandId playerIslandId);
    Optional<PlayerIsland> getByProfileId(ProfileId profileId);
}

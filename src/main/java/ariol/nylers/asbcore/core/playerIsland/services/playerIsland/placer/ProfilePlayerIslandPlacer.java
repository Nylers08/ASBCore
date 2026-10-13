package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.ProfilePlayerIslandRegistry;
import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;


public class ProfilePlayerIslandPlacer {

    @Getter
    private final PlayerIslandPlacer placer;

    @Getter
    private final ProfilePlayerIslandRegistry registry;

    public ProfilePlayerIslandPlacer(PlayerIslandPlacer placer, ProfilePlayerIslandRegistry registry) {
        this.placer = placer;
        this.registry = registry;
    }

    public void place(ProfileId profileId){
        PlayerIsland playerIsland = registry.get(profileId);
        placer.paste(playerIsland);
    }
}

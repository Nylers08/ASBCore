package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.ProfilePlayerIslandRegistry;
import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.ProfileId;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;
import lombok.Getter;

import java.util.UUID;

public class MegaPlayerIslandPlacer {

    @Getter
    private final ProfilePlayerIslandPlacer placer;

    @Getter
    private final SelectedMetaProfileRegistry selectedMetaProfileRegistry;

    public MegaPlayerIslandPlacer(ProfilePlayerIslandPlacer placer, SelectedMetaProfileRegistry selectedMetaProfileRegistry) {
        this.placer = placer;
        this.selectedMetaProfileRegistry = selectedMetaProfileRegistry;
    }


    public void place(UUID playerId){
        MetaProfile metaProfile = selectedMetaProfileRegistry.getSelectedProfileMetaData(playerId);
        ProfileId profileId = metaProfile.getProfileId();
        placer.place(profileId);
    }
}

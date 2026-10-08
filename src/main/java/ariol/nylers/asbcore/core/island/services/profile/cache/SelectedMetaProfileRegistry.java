package ariol.nylers.asbcore.core.island.services.profile.cache;

import ariol.nylers.asbcore.core.island.profile.MetaProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SelectedMetaProfileRegistry {

    private final Map<UUID, MetaProfile> currentPlayersProfile = new HashMap<>();

    public void selectProfile(UUID playerUuid, MetaProfile metaData){
        currentPlayersProfile.put(playerUuid, metaData);
    }

    public void remove(UUID playerUuid){
        currentPlayersProfile.remove(playerUuid);
    }

    public boolean isProfileSelected(UUID playerUuid){
        return currentPlayersProfile.containsKey(playerUuid);
    }

    public MetaProfile getSelectedProfileMetaData(UUID playerUuid){
        return currentPlayersProfile.get(playerUuid);
    }
}

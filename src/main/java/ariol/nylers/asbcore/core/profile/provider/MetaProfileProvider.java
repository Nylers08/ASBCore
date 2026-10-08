package ariol.nylers.asbcore.core.profile.provider;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.ProfileId;
import ariol.nylers.asbcore.core.profile.cache.PlayerMetaProfileCache;
import ariol.nylers.asbcore.core.profile.db.MetaProfileRepository;

import java.util.UUID;

public class MetaProfileProvider {

    private final PlayerMetaProfileCache playerMetaProfileCache;
    private final MetaProfileRepository metaProfileRepository;

    public MetaProfileProvider(PlayerMetaProfileCache playerMetaProfileCache, MetaProfileRepository metaProfileRepository) {
        this.playerMetaProfileCache = playerMetaProfileCache;
        this.metaProfileRepository = metaProfileRepository;
    }

    public MetaProfile getMetaProfile(ProfileId profileId){
        return null;
    }

    public MetaProfile getMetaProfile(UUID playerId){
        return null;
    }

    public UUID getPlayerId(ProfileId profileId){
        return null;
    }


}

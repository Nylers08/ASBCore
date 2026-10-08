package ariol.nylers.asbcore.core.island.profile;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.UUID;

public class MetaProfile {

    @Getter @Setter private ProfileId profileId;
    @Getter @Setter private UUID playerUuid;
    @Getter @Setter private String profileName;
    @Getter @Setter private Duration gameTime;
    @Getter @Setter private int islandLevel;

    public MetaProfile(ProfileId profileId, UUID playerUuid, String profileName, Duration gameTime, int islandLevel){
        this.profileId = profileId;
        this.playerUuid = playerUuid;
        this.profileName = profileName;
        this.gameTime = gameTime;
        this.islandLevel = islandLevel;
    }

    public MetaProfile(){}
}

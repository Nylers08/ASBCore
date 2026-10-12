package ariol.nylers.asbcore.core.playerIsland.services.region.configurator;

import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public record RegionWithMembership(
        ProtectedRegion region,
        Membership membership
) {
}

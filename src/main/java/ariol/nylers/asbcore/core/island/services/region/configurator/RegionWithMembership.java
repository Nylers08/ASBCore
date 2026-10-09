package ariol.nylers.asbcore.core.island.services.region.configurator;

import ariol.nylers.asbcore.core.island.members.Membership;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public record RegionWithMembership(
        ProtectedRegion region,
        Membership membership
) {
}

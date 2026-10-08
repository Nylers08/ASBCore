package ariol.nylers.asbcore.core.island.services.region;

import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.region.IslandRegion;
import ariol.nylers.asbcore.core.utils.adapters.WorldEditAdapter;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RegionPlacer {

    public void place(IslandRegion region, Membership membership){
        ProtectedRegion protectedRegion = WorldEditAdapter.adapt(region);

    }
}

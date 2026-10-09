package ariol.nylers.asbcore.core.island.services.region.placer;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public interface PrivatePlacer<PrivatePlaceData> {

    ProtectedRegion place(PrivatePlaceData placeData);
}

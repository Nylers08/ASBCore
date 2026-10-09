package ariol.nylers.asbcore.core.utils.adapters;

import ariol.nylers.asbcore.core.island.region.IslandRegion;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class WorldEditAdapter {

    public static BlockVector3 adaptByWorldCord(IslandLocalLocation location){
        return BlockVector3.at(location.getWorldX(), location.getWorldY(), location.getWorldZ());
    }

    public static BlockVector3 adaptByLocalCord(IslandLocalLocation location){
        return BlockVector3.at(location.getLocalX(), location.getLocalY(), location.getLocalZ());
    }


    public static ProtectedRegion adapt(IslandRegion region){
        String regionId = region.getUuid().toString();
        BlockVector3 minPos = adaptByWorldCord(region.getMinLocalPos());
        BlockVector3 maxPos = adaptByWorldCord(region.getMaxLocalPos());
        return new ProtectedCuboidRegion(regionId, minPos, maxPos);
    }
}

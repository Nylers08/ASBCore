package ariol.nylers.asbcore.core.utils.worldGuard;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.managers.storage.StorageException;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.World;

public class ProtectedRegionUtils {

    public static void register(ProtectedRegion region, World world){
        String regionId = region.getId();
        RegionManager regionManager = getRegionManager(world);

        if(regionManager.hasRegion(regionId)){
            regionManager.removeRegion(regionId);
        }

        regionManager.addRegion(region);

        saveRegionManager(regionManager);
    }

    public static RegionManager getRegionManager(World world){
        com.sk89q.worldedit.world.World weWorld = BukkitAdapter.adapt(world);
        return WorldGuard.getInstance().getPlatform().getRegionContainer().get(weWorld);
    }

    public static void saveRegionManager(RegionManager regionManager){
        try {
            regionManager.save();
        } catch (StorageException e) {
            throw new RuntimeException(e);
        }
    }
}

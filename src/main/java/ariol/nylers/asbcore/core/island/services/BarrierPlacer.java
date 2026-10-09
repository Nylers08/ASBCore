package ariol.nylers.asbcore.core.island.services;

import ariol.nylers.asbcore.core.utils.worldGuard.WallPlacerUtils;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.world.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class BarrierPlacer {

    public static void place(Location center, int radius){
        BlockVector3 minPos = BlockVector3.at(center.getX()-radius, -64, center.getZ()-radius);
        BlockVector3 maxPos = BlockVector3.at(center.getX()+radius, 320, center.getZ()+radius);
        World weWorld = BukkitAdapter.adapt(center.getWorld());
        WallPlacerUtils.makeWalls(weWorld, minPos, maxPos, Bukkit.createBlockData(Material.BARRIER));
    }
}

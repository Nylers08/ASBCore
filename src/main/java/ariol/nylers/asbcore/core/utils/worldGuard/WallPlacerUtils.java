package ariol.nylers.asbcore.core.utils.worldGuard;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.function.pattern.Pattern;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.world.World;
import org.bukkit.block.data.BlockData;

public class WallPlacerUtils {

    public static void makeWalls(World world, BlockVector3 minPoint, BlockVector3 maxPoint, BlockData blockData){
        try(EditSession editSession = WorldEdit.getInstance().newEditSession(world)) {
            Pattern pattern = BukkitAdapter.adapt(blockData);
            editSession.makeWalls(new CuboidRegion(world, minPoint, maxPoint), pattern);
        } catch (MaxChangedBlocksException e) {
            throw new RuntimeException(e);
        }
    }
}

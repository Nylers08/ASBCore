package ariol.nylers.asbcore.core.island.services.clipboard;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.BlockArrayClipboard;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.function.operation.ForwardExtentCopy;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;
import org.bukkit.Location;

public class ClipboardFetcher {

    public Clipboard fetch(Location pos1, Location pos2){
        throwIfNotEqualsWorld(pos1, pos2);

        World weWorld = BukkitAdapter.adapt(pos1.getWorld());
        BlockVector3 minPos = BlockVector3.at(pos1.x(), pos1.y(), pos1.z());
        BlockVector3 maxPos = BlockVector3.at(pos2.x(), pos2.y(), pos2.z());
        BlockVector3 center = (minPos.plus(maxPos)).divide(2);

        CuboidRegion region = new CuboidRegion(minPos, maxPos);
        return copy(weWorld, region, center);
    }

    private void throwIfNotEqualsWorld(Location pos1, Location pos2){
        if(!pos1.getWorld().equals(pos2.getWorld())){
            throw new ASBClipboardException("В pos1 и pos2 отличаются миры");
        }
    }

    private Clipboard copy(World weWorld, Region region, BlockVector3 origin){
        Clipboard clipboard = new BlockArrayClipboard(region);
        clipboard.setOrigin(origin);

        EditSession editSession = WorldEdit.getInstance().newEditSession(weWorld);
        ForwardExtentCopy copyOperation = buildCopyOperation(editSession, region, clipboard, origin);
        Operations.complete(copyOperation);
        editSession.close();

        return clipboard;
    }

    private ForwardExtentCopy buildCopyOperation(EditSession editSession, Region region,
                                                 Clipboard clipboard, BlockVector3 loc){

        ForwardExtentCopy copyOperation = new ForwardExtentCopy(
                editSession,
                region,
                clipboard,
                loc
        );
        copyOperation.setCopyingBiomes(true);
        copyOperation.setCopyingEntities(true);

        return copyOperation;
    }
}

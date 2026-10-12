package ariol.nylers.asbcore.core.playerIsland.services.clipboard;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import org.bukkit.Location;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class ClipboardPlacer {

    public CompletableFuture<Void> place(Location location, Clipboard clipboard){
        return CompletableFuture.runAsync(()->{
            World weWorld = BukkitAdapter.adapt(location.getWorld());
            BlockVector3 weLoc = BlockVector3.at(location.x(), location.y(), location.z());
            tryExecutePlace(weWorld, weLoc, clipboard);
        });
    }

    private void tryExecutePlace(World weWorld, BlockVector3 location, Clipboard clipboard){
        try {
            executePlace(weWorld, location, clipboard);
        } catch (WorldEditException e){
            throw new CompletionException(e);
        }
    }

    private void executePlace(World weWorld, BlockVector3 location, Clipboard clipboard) throws WorldEditException{
        EditSession editSession = buildEditSession(weWorld);
        Operation operation = buildOperationPaste(location, clipboard, editSession);
        Operations.complete(operation);
        editSession.close();
    }

    private EditSession buildEditSession(World weWorld){
        return WorldEdit.getInstance()
                .newEditSessionBuilder()
                .world(weWorld)
                .limitUnlimited()
                .fastMode(true)
                .build();
    }

    private Operation buildOperationPaste(BlockVector3 location, Clipboard clipboard, EditSession editSession){
        return new ClipboardHolder(clipboard)
                .createPaste(editSession)
                .to(location)
                .ignoreAirBlocks(true)
                .copyBiomes(true)
                .build();
    };

}

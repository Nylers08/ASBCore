package ariol.nylers.asbcore.core.playerIsland.services.island.paste;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import org.bukkit.Location;

import java.util.concurrent.CompletableFuture;

public interface IslandPaste {

    public CompletableFuture<Void> place(Island island, Location location);
}

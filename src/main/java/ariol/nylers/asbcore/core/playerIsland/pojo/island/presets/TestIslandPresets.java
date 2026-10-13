package ariol.nylers.asbcore.core.playerIsland.pojo.island.presets;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class TestIslandPresets extends IslandPlacementPreset{

    public TestIslandPresets(){
        super();

        World world = Bukkit.getWorld("world");
        put(world, new ClipboardId("test"));
    }
}

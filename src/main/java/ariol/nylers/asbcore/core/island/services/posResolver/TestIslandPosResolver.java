package ariol.nylers.asbcore.core.island.services.posResolver;

import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class TestIslandPosResolver implements IslandPosResolver{

    @Override
    public IslandLocalLocation resolve() {
        Location origin = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        return new IslandLocalLocation(origin, 0, 0 ,0);
    }
}

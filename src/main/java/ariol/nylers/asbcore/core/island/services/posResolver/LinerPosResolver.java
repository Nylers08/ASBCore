package ariol.nylers.asbcore.core.island.services.posResolver;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.HashMap;
import java.util.Map;

public class LinerPosResolver implements IslandPosResolver<World>{

    private final Map<World, Location> lastLocations = new HashMap<>();
    private final double offsetX = 50;

    @Override
    public Location resolve(World world) {
        Location lastLocation = getLastLocation(world);
        lastLocation.add(offsetX,0,0);
        return lastLocation;
    }

    private Location getLastLocation(World world){
        if(!lastLocations.containsKey(world)){
            Location location = new Location(world, 0, 0, 0);
            lastLocations.put(world, location);
        }

        return lastLocations.get(world);
    }
}

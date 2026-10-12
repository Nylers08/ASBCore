package ariol.nylers.asbcore.core.playerIsland.services.posResolver;

import org.bukkit.Location;

public interface IslandPosResolver<Context> {

    Location resolve(Context context);
}

package ariol.nylers.asbcore.core.playerIsland.services.islandOwnership;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import ariol.nylers.asbcore.core.playerIsland.pojo.IslandOwnership;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import ariol.nylers.asbcore.core.playerIsland.services.island.factory.IslandCreateContext;
import ariol.nylers.asbcore.core.playerIsland.services.island.factory.IslandFactory;
import org.bukkit.World;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BaseIslandOwnershipFactory implements IslandOwnershipFactory<IslandOwnershipCreateContext>{

    private final IslandFactory<IslandCreateContext> islandFactory;

    public BaseIslandOwnershipFactory(IslandFactory<IslandCreateContext> islandFactory) {
        this.islandFactory = islandFactory;
    }

    @Override
    public IslandOwnership create(IslandOwnershipCreateContext context) {
        Set<Island> islands = createIslands(context);
        IslandOwnership islandOwnership = new IslandOwnership();
        islandOwnership.addAll(islands);
        return islandOwnership;
    }

    private Set<Island> createIslands(IslandOwnershipCreateContext context){
        Set<Island> islands = new HashSet<>();
        Membership membership = context.getMembership();
        for (Map.Entry<World, ClipboardId> entry : context.getPreset().entrySet()){
            IslandCreateContext createContext = buildIslandCreateContext(entry, membership);
            Island island = islandFactory.create(createContext);
            islands.add(island);
        }
        return islands;
    }

    private IslandCreateContext buildIslandCreateContext(Map.Entry<World, ClipboardId> entry, Membership membership){
        return new IslandCreateContext(
                entry.getKey(),
                entry.getValue(),
                membership);
    }
}

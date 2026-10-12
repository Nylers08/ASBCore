package ariol.nylers.asbcore.core.playerIsland.services.islandOwnership;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import ariol.nylers.asbcore.core.playerIsland.pojo.IslandOwnership;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPlacementPreset;
import ariol.nylers.asbcore.core.playerIsland.services.island.factory.IslandCreateContext;
import ariol.nylers.asbcore.core.playerIsland.services.island.factory.IslandFactory;
import org.bukkit.World;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BaseIslandOwnershipFactory implements IslandOwnershipFactory<IslandPlacementPreset>{

    private final IslandFactory<IslandCreateContext> islandFactory;

    public BaseIslandOwnershipFactory(IslandFactory<IslandCreateContext> islandFactory) {
        this.islandFactory = islandFactory;
    }

    @Override
    public IslandOwnership create(IslandPlacementPreset preset) {
        Set<Island> islands = createIslands(preset);
        IslandOwnership islandOwnership = new IslandOwnership();
        islandOwnership.addAll(islands);
        return islandOwnership;
    }

    private Set<Island> createIslands(IslandPlacementPreset preset){
        Set<Island> islands = new HashSet<>();
        for (Map.Entry<World, ClipboardId> entry : preset.entrySet()){
            IslandCreateContext createContext = new IslandCreateContext(entry.getKey(), entry.getValue());
            Island island = islandFactory.create(createContext);
        }
        return islands;
    }
}

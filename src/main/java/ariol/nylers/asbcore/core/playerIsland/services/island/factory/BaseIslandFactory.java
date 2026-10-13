package ariol.nylers.asbcore.core.playerIsland.services.island.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.IslandData;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.IslandSettings;
import ariol.nylers.asbcore.core.playerIsland.pojo.region.IslandRegion;
import ariol.nylers.asbcore.core.playerIsland.services.clipboard.provider.ClipboardProvider;
import ariol.nylers.asbcore.core.playerIsland.services.region.factory.IslandRegionFactory;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import org.bukkit.Location;

import java.util.Optional;

public class BaseIslandFactory implements IslandFactory<IslandCreateContext>{

    private final ClipboardProvider clipboardProvider;
    private final IslandSettingsFactory islandSettingsFactory;
    private final IslandRegionFactory<IslandSettings> islandRegionFactory;

    public BaseIslandFactory(ClipboardProvider clipboardProvider,
                             IslandSettingsFactory islandSettingsFactory,
                             IslandRegionFactory<IslandSettings> islandRegionFactory) {

        this.clipboardProvider = clipboardProvider;
        this.islandSettingsFactory = islandSettingsFactory;
        this.islandRegionFactory = islandRegionFactory;
    }

    @Override
    public Island create(IslandCreateContext createContext) {
        Optional<Clipboard> optClipboard = clipboardProvider.find(createContext.getClipboardId());

        if(optClipboard.isEmpty()){
            throw new RuntimeException("Не удалось загрузить Clipboard, при создании острова");
        }

        IslandSettings islandSettings = islandSettingsFactory.create();
        IslandRegion islandRegion = islandRegionFactory.create(islandSettings);
        Location location = new Location(createContext.getWorld(), 0, 0 ,0);
        IslandData islandData = new IslandData(optClipboard.get(), islandRegion, location);

        return new Island(islandData, createContext.getMembership(), islandSettings);
    }
}

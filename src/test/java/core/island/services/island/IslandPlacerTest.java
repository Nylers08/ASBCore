package core.island.services.island;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.services.clipboard.ClipboardPlacer;
import ariol.nylers.asbcore.core.island.services.island.IslandPlacer;
import ariol.nylers.asbcore.core.island.services.region.placer.ConfiguredRegionPlacer;
import ariol.nylers.asbcore.core.island.services.region.placer.IslandRegionPlacementContext;
import ariol.nylers.asbcore.core.island.services.region.placer.PrivatePlacer;
import org.bukkit.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;

@ExtendWith(MockitoExtension.class)
public class IslandPlacerTest {

    @Mock
    private ClipboardPlacer clipboardPlacer;

    @Mock
    private ConfiguredRegionPlacer regionPlacer;

    @Mock
    private Island island;

    @Mock
    private Location location;

    private IslandPlacer islandPlacer;


    @BeforeEach
    public void setup(){
        this.islandPlacer = new IslandPlacer(clipboardPlacer, regionPlacer);
    }


    @Test
    public void placeTest(){
        CompletableFuture<Void> future = islandPlacer.place(island, location);

        future.thenApply(fn->{
            Mockito.verify(clipboardPlacer.place(location, island.getClipboard()));
            Mockito.verify(regionPlacer).place(Mockito.argThat(context->
                    context.getIslandRegionPlaceData() != null
                            && context.getMembership() != island.getMembership()));
            return fn;
        });

    }
}

package core.island.services.island;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.services.clipboard.ClipboardPlacer;
import ariol.nylers.asbcore.core.island.services.island.paste.IslandPasteExecutor;
import ariol.nylers.asbcore.core.island.services.region.placer.ConfiguredRegionPlacer;
import org.bukkit.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;

@ExtendWith(MockitoExtension.class)
public class IslandPasteExecutorTest {

    @Mock
    private ClipboardPlacer clipboardPlacer;

    @Mock
    private ConfiguredRegionPlacer regionPlacer;

    @Mock
    private Island island;

    @Mock
    private Location location;

    private IslandPasteExecutor islandPasteExecutor;


    @BeforeEach
    public void setup(){
        this.islandPasteExecutor = new IslandPasteExecutor(clipboardPlacer, regionPlacer);
    }


    @Test
    public void placeTest(){
        CompletableFuture<Void> future = islandPasteExecutor.place(island, location);

        future.thenApply(fn->{
            Mockito.verify(clipboardPlacer.place(location, island.getClipboard()));
            Mockito.verify(regionPlacer).place(Mockito.argThat(context->
                    context.getIslandRegionPlaceData() != null
                            && context.getMembership() != island.getMembership()));
            return fn;
        });

    }
}

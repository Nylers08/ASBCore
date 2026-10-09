package core.island.services.region;

import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.services.region.configurator.PrivateConfigurator;
import ariol.nylers.asbcore.core.island.services.region.configurator.RegionWithMembership;
import ariol.nylers.asbcore.core.island.services.region.placer.ConfiguredRegionPlacer;
import ariol.nylers.asbcore.core.island.services.region.placer.IslandRegionPlaceData;
import ariol.nylers.asbcore.core.island.services.region.placer.IslandRegionPlacementContext;
import ariol.nylers.asbcore.core.island.services.region.placer.PrivatePlacer;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConfiguredRegionPlacerTest {

    private ConfiguredRegionPlacer configuredPrivatePlacer;

    @Mock
    private PrivatePlacer<IslandRegionPlaceData> placer;

    @Mock
    private PrivateConfigurator<RegionWithMembership> configurator;

    @Mock
    private IslandRegionPlaceData islandRegionPlaceData;

    @Mock
    private ProtectedRegion protectedRegion;

    @Mock
    private Membership membership;

    @BeforeEach
    public void setup(){
        configuredPrivatePlacer = new ConfiguredRegionPlacer(placer, configurator);

        Mockito.when(placer.place(islandRegionPlaceData))
                .thenReturn(protectedRegion);
    }

    @Test
    public void placeTest(){
        IslandRegionPlacementContext placeData = new IslandRegionPlacementContext(
                islandRegionPlaceData, membership
        );
        ProtectedRegion result = configuredPrivatePlacer.place(placeData);

        assertSame(result, protectedRegion);

        verify(placer).place(islandRegionPlaceData);
        verify(configurator).configure(argThat(config->
                config.region()==protectedRegion
                && config.membership() == membership
        ));
    }
}

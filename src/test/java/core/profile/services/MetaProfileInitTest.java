package core.profile.services;

import ariol.nylers.asbcore.core.profile.cache.PlayerMetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;
import ariol.nylers.asbcore.core.profile.modules.ProfileCaches;
import ariol.nylers.asbcore.core.profile.services.MetaProfileInit;
import ariol.nylers.asbcore.core.profile.services.MetaProfilesCacheLoader;
import ariol.nylers.asbcore.core.profile.services.ProfileCreator;
import ariol.nylers.asbcore.core.profile.services.SelectedMetaProfileLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MetaProfileInitTest {

    @Mock
    private ProfileCaches profileCaches;

    @Mock
    private MetaProfilesCacheLoader cacheLoader;

    @Mock
    private ProfileCreator profileCreator;

    @Mock
    private SelectedMetaProfileLoader selectedMetaProfileLoader;


    @Mock
    private PlayerMetaProfileCache playerMetaProfileCache;

    @Mock
    private SelectedMetaProfileRegistry selectedMetaProfileRegistry;


    private MetaProfileInit metaProfileInit;

    @BeforeEach
    void setup(){
        metaProfileInit = new MetaProfileInit(
                profileCaches,
                cacheLoader,
                profileCreator,
                selectedMetaProfileLoader
        );

        when(profileCaches.playerMetaProfileCache())
                .thenReturn(playerMetaProfileCache);

        when(profileCaches.selectedMetaProfileRegistry())
                .thenReturn(selectedMetaProfileRegistry);
    }


    @Test
    void shouldDoNothingWhenProfileIsCachedAndSelected(){
        UUID playerId = UUID.randomUUID();

        when(playerMetaProfileCache.containsValue(playerId))
                .thenReturn(true);

        when(selectedMetaProfileRegistry.isProfileSelected(playerId))
                .thenReturn(true);

        metaProfileInit.init(playerId);

        verifyNoInteractions(
                cacheLoader,
                profileCreator,
                selectedMetaProfileLoader
        );
    }

    @Test
    void shouldCreateProfileWhenNotCachedAndNotFoundInDB() {
        UUID playerId = UUID.randomUUID();

        when(playerMetaProfileCache.containsValue(playerId))
                .thenReturn(false);

        when(cacheLoader.tryCacheFromDB(playerId))
                .thenReturn(false);

        when(selectedMetaProfileRegistry.isProfileSelected(playerId))
                .thenReturn(true);

        metaProfileInit.init(playerId);

        verify(cacheLoader).tryCacheFromDB(playerId);
        verify(profileCreator).createNewProfile(playerId);
    }
}

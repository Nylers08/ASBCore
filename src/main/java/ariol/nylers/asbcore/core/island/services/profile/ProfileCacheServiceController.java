package ariol.nylers.asbcore.core.island.services.profile;

import ariol.nylers.asbcore.core.island.profile.db.EmptyProfileMetaDataLoader;
import ariol.nylers.asbcore.core.island.profile.db.EmptyProfileSaver;
import ariol.nylers.asbcore.core.island.profile.db.EmptySelectedMetaProfileLoader;
import ariol.nylers.asbcore.core.island.profile.db.EmptySelectedProfileSaver;
import ariol.nylers.asbcore.core.island.services.profile.cache.BaseProfileCacheFacadeFactory;
import ariol.nylers.asbcore.core.island.services.profile.cache.MetaProfileInit;
import ariol.nylers.asbcore.core.island.services.profile.cache.MetaProfilesCacheLoader;
import ariol.nylers.asbcore.core.island.services.profile.cache.ProfileCacheFacade;
import lombok.Getter;

public class ProfileCacheServiceController {

    @Getter private final ProfileCacheFacade cacheFacade = new BaseProfileCacheFacadeFactory().create(new Object());
    @Getter private final MetaProfilesCacheLoader cacheLoader = new MetaProfilesCacheLoader(cacheFacade.metaProfileCache(), new EmptyProfileMetaDataLoader());
    @Getter private final ProfileCreator profileCreator = new ProfileCreator(new TempProfileFactory(), cacheFacade, new EmptyProfileSaver());
    @Getter private final MetaProfileSelector selector = new MetaProfileSelector(
            cacheFacade,
            new EmptySelectedMetaProfileLoader(),
            new EmptySelectedProfileSaver());


    @Getter private final MetaProfileInit metaProfileInit = new MetaProfileInit(
            cacheFacade,
            cacheLoader,
            profileCreator,
            selector
    );
}

package ariol.nylers.asbcore.core.profile;

import ariol.nylers.asbcore.core.profile.controller.MetaProfileCacheController;
import ariol.nylers.asbcore.core.profile.controller.ProfileCacheController;
import ariol.nylers.asbcore.core.profile.db.EmptySelectedMetaProfileLoader;
import ariol.nylers.asbcore.core.profile.db.EmptySelectedProfileSaver;
import ariol.nylers.asbcore.core.profile.services.MetaProfileProvider;
import ariol.nylers.asbcore.core.profile.factory.BaseProfileCacheFacadeFactory;
import ariol.nylers.asbcore.core.profile.db.EmptyMetaProfileRepository;
import ariol.nylers.asbcore.core.profile.db.EmptyProfileRepository;
import ariol.nylers.asbcore.core.profile.db.MetaProfileRepository;
import ariol.nylers.asbcore.core.profile.db.ProfileRepository;
import ariol.nylers.asbcore.core.profile.services.MetaProfileInit;
import ariol.nylers.asbcore.core.profile.services.MetaProfilesCacheLoader;
import ariol.nylers.asbcore.core.profile.modules.ProfileCaches;
import ariol.nylers.asbcore.core.profile.services.SelectedMetaProfileLoader;
import ariol.nylers.asbcore.core.profile.services.ProfileCreator;
import ariol.nylers.asbcore.core.profile.factory.TempProfileFactory;
import lombok.Getter;

public class ProfileModule {


    @Getter private final MetaProfileRepository metaProfileRepository = new EmptyMetaProfileRepository();
    @Getter private final ProfileRepository profileRepository = new EmptyProfileRepository();

    @Getter private final ProfileCaches profileCaches = new BaseProfileCacheFacadeFactory().create(new Object());
    @Getter private final MetaProfileCacheController metaProfileCacheController = new MetaProfileCacheController(
            profileCaches.playerMetaProfileCache(),
            profileCaches.metaProfileCache(),
            profileCaches.selectedMetaProfileRegistry()
    );
    @Getter private final ProfileCacheController profileCacheController = new ProfileCacheController(
            metaProfileCacheController,
            profileCaches.profileCache());

    @Getter private final MetaProfilesCacheLoader cacheLoader = new MetaProfilesCacheLoader(
            metaProfileCacheController, metaProfileRepository);

    @Getter private final ProfileCreator profileCreator = new ProfileCreator(
            new TempProfileFactory(), profileCacheController, profileRepository);

    @Getter private final SelectedMetaProfileLoader selector = new SelectedMetaProfileLoader(
            profileCaches,
            new EmptySelectedMetaProfileLoader(),
            new EmptySelectedProfileSaver());


    @Getter private final MetaProfileInit metaProfileInit = new MetaProfileInit(
            profileCaches,
            cacheLoader,
            profileCreator,
            selector
    );

    @Getter private final MetaProfileProvider metaProfileProvider = new MetaProfileProvider(
            metaProfileCacheController,
            metaProfileRepository
    );
}

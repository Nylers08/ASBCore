package ariol.nylers.asbcore.core.island.services.profile.cache;

public class BaseProfileCacheFacadeFactory implements ProfileCacheFacadeFactory<Object>{

    @Override
    public ProfileCacheFacade create(Object o) {
        MetaProfileCache metaProfileCache = new MetaProfileCache();
        SelectedMetaProfileRegistry selectedMetaProfileRegistry = new SelectedMetaProfileRegistry();
        ProfileCache profileCache = new ProfileCache();

        return new ProfileCacheFacade(
                metaProfileCache,
                selectedMetaProfileRegistry,
                profileCache
        );
    }
}

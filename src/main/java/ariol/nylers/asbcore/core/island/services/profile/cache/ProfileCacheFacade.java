package ariol.nylers.asbcore.core.island.services.profile.cache;

public record ProfileCacheFacade(
        MetaProfileCache metaProfileCache,
        SelectedMetaProfileRegistry selectedMetaProfileRegistry,
        ProfileCache profileCache) {

}

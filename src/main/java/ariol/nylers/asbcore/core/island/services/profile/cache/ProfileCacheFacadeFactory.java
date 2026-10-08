package ariol.nylers.asbcore.core.island.services.profile.cache;

public interface ProfileCacheFacadeFactory<Param>{

    ProfileCacheFacade create(Param param);
}

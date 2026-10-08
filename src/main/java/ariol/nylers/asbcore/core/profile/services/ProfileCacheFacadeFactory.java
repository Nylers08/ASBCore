package ariol.nylers.asbcore.core.profile.services;

public interface ProfileCacheFacadeFactory<Param>{

    ProfileCaches create(Param param);
}

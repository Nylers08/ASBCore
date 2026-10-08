package ariol.nylers.asbcore.core.profile;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

public class Profile {

    @Getter @Setter @Delegate
    private MetaProfile metaData;

    @Getter @Setter @Delegate
    private ProfileData data;


    public Profile(MetaProfile metaData){
        this.metaData = metaData;
    }

    public Profile(MetaProfile metaData, ProfileData data){
        this.metaData = metaData;
        this.data = data;
    }
}

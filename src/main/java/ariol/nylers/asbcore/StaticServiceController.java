package ariol.nylers.asbcore;

import lombok.Getter;
import lombok.experimental.Delegate;

public class StaticServiceController {

    @Getter
    private static ServiceController serviceController;

    public static void init(ServiceController _serviceController){
        serviceController = _serviceController;
    }
}

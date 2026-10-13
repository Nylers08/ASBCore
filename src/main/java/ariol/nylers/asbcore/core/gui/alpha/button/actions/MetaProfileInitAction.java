package ariol.nylers.asbcore.core.gui.alpha.button.actions;

import ariol.nylers.asbcore.core.profile.services.MetaProfileInit;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.controller.actions.ButtonAction;
import io.neris.NGui.core.services.StaticMenuServiceController;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MetaProfileInitAction implements ButtonAction {

    private final MetaProfileInit metaProfileInit;

    public MetaProfileInitAction(MetaProfileInit metaProfileInit) {
        this.metaProfileInit = metaProfileInit;
        StaticMenuServiceController.getServiceController().getNbtActionRegistry().register(this);
    }

    @Override
    public String key() {
        return "meta_profile_init";
    }

    @Override
    public String value() {
        return "true";
    }

    @Override
    public void execute(ClickEventContext clickContext) {
        Player player = (Player) clickContext.whoClicked;
        UUID playerId = player.getUniqueId();
        metaProfileInit.init(playerId);
    }
}

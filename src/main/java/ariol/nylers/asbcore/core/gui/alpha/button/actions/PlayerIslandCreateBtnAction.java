package ariol.nylers.asbcore.core.gui.alpha.button.actions;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.TestIslandPresets;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreateContext;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreator;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreatorByPlayerId;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory.PlayerIslandFactoryContext;
import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.controller.actions.ButtonAction;
import io.neris.NGui.core.services.StaticMenuServiceController;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerIslandCreateBtnAction implements ButtonAction {

    private final PlayerIslandCreatorByPlayerId playerIslandCreator;

    public PlayerIslandCreateBtnAction(PlayerIslandCreatorByPlayerId playerIslandCreator) {
        this.playerIslandCreator = playerIslandCreator;
        StaticMenuServiceController.getServiceController().getNbtActionRegistry().register(this);
    }

    @Override
    public String key() {
        return "player_island_create";
    }

    @Override
    public String value() {
        return "true";
    }

    @Override
    public void execute(ClickEventContext clickContext) {
        Player player = (Player) clickContext.whoClicked;
        UUID playerId = player.getUniqueId();

        PlayerIslandCreateContext createContext = new PlayerIslandCreateContext(playerId, new TestIslandPresets());
        playerIslandCreator.create(createContext);
    }


}

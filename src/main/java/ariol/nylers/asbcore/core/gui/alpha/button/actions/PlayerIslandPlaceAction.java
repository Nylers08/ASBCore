package ariol.nylers.asbcore.core.gui.alpha.button.actions;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer.PlayerIslandPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer.ProfilePlayerIslandPlacer;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.controller.actions.ButtonAction;
import io.neris.NGui.core.services.StaticMenuServiceController;

public class PlayerIslandPlaceAction implements ButtonAction {

    private final PlayerIslandPlacer placer;

    private final PlayerIsland playerIsland;

    public PlayerIslandPlaceAction(PlayerIslandPlacer placer, PlayerIsland playerIsland) {
        this.placer = placer;
        this.playerIsland = playerIsland;
        StaticMenuServiceController.getServiceController().getNbtActionRegistry().register(this);
    }


    @Override
    public String key() {
        return "player_island_place_" + playerIsland.getId().toString();
    }

    @Override
    public String value() {
        return "true";
    }

    @Override
    public void execute(ClickEventContext clickContext) {
        placer.paste(playerIsland);
    }
}

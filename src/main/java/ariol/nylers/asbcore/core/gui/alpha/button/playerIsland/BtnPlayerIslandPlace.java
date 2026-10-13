package ariol.nylers.asbcore.core.gui.alpha.button.playerIsland;

import ariol.nylers.asbcore.StaticServiceController;
import ariol.nylers.asbcore.core.gui.alpha.button.actions.PlayerIslandCreateBtnAction;
import ariol.nylers.asbcore.core.gui.alpha.button.actions.PlayerIslandPlaceAction;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreatorByPlayerId;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer.PlayerIslandPlacer;
import io.neris.NGui.core.gui.button.button.StaticNbtButton;
import io.neris.NGui.core.gui.button.controller.ButtonController;
import io.neris.NGui.core.gui.button.controller.actions.ButtonAction;
import io.neris.NGui.core.gui.button.controller.actions.CancelPutAction;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderer;
import io.neris.NGui.core.gui.button.controller.renderers.SimpleRenderer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BtnPlayerIslandPlace extends StaticNbtButton {

    public BtnPlayerIslandPlace(ButtonRenderContext renderContext, PlayerIsland playerIsland) {
        ButtonController btnController = buildButtonController(playerIsland);
        btnController.addAction(new CancelPutAction());
        super(btnController, renderContext);
    }

    private static ButtonController buildButtonController(PlayerIsland playerIsland){
        ButtonRenderer renderer = buildRenderer(playerIsland);
        ButtonAction action = buildAction(playerIsland);
        return new ButtonController(renderer, new ArrayList<>(List.of(action)));
    }

    private static ButtonRenderer buildRenderer(PlayerIsland playerIsland){
        return new SimpleRenderer(
                Material.NETHER_STAR,
                1,
                Component.text("Place PlayerIsland: " + playerIsland.getId().toString())
        );
    }

    private static ButtonAction buildAction(PlayerIsland playerIsland){
        PlayerIslandPlacer placer = StaticServiceController.getServiceController().getPlayerIslandPlacer();
        return new PlayerIslandPlaceAction(placer, playerIsland);
    }
}

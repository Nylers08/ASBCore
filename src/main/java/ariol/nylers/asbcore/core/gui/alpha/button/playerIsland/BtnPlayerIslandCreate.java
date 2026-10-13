package ariol.nylers.asbcore.core.gui.alpha.button.playerIsland;

import ariol.nylers.asbcore.StaticServiceController;
import ariol.nylers.asbcore.core.gui.alpha.button.actions.PlayerIslandCreateBtnAction;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreatorByPlayerId;
import io.neris.NGui.core.gui.button.button.StaticNbtButton;
import io.neris.NGui.core.gui.button.controller.ButtonController;
import io.neris.NGui.core.gui.button.controller.actions.ButtonAction;
import io.neris.NGui.core.gui.button.controller.actions.CancelPutAction;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderer;
import io.neris.NGui.core.gui.button.controller.renderers.SimpleRenderer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class BtnPlayerIslandCreate extends StaticNbtButton {

    public BtnPlayerIslandCreate(ButtonRenderContext renderContext) {
        PlayerIslandCreatorByPlayerId playerIslandCreator = StaticServiceController.getServiceController().getPlayerIslandCreatorByPlayerId();
        ButtonController btnController = buildButtonController(playerIslandCreator);
        btnController.addAction(new CancelPutAction());
        super(btnController, renderContext);
    }

    private static ButtonController buildButtonController(PlayerIslandCreatorByPlayerId playerIslandCreator){
        ButtonRenderer renderer = buildRenderer();
        ButtonAction action = buildAction(playerIslandCreator);
        return new ButtonController(renderer, new ArrayList<>(List.of(action)));
    }

    private static ButtonRenderer buildRenderer(){
        return new SimpleRenderer(
                Material.NETHER_STAR,
                1,
                Component.text("Create PlayerIsland")
        );
    }

    private static ButtonAction buildAction(PlayerIslandCreatorByPlayerId playerIslandCreator){
        return new PlayerIslandCreateBtnAction(playerIslandCreator);
    }
}

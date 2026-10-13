package ariol.nylers.asbcore.core.gui.alpha.button.profile;

import ariol.nylers.asbcore.StaticServiceController;
import ariol.nylers.asbcore.core.gui.alpha.button.actions.MetaProfileInitAction;
import ariol.nylers.asbcore.core.gui.alpha.button.actions.PlayerIslandCreateBtnAction;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreatorByPlayerId;
import ariol.nylers.asbcore.core.profile.services.MetaProfileInit;
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
import java.util.Arrays;
import java.util.List;

public class BtnProfileInit extends StaticNbtButton {

    public BtnProfileInit(ButtonRenderContext renderContext) {
        ButtonController btnController = buildButtonController();
        btnController.addAction(new CancelPutAction());

        super(btnController, renderContext);
    }

    private static ButtonController buildButtonController(){
        ButtonRenderer renderer = buildRenderer();
        ButtonAction action = buildAction();
        return new ButtonController(renderer, new ArrayList<>(List.of(action)));
    }

    private static ButtonRenderer buildRenderer(){
        return new SimpleRenderer(
                Material.NETHER_STAR,
                1,
                Component.text("MetaProfile init")
        );
    }

    private static ButtonAction buildAction(){
        MetaProfileInit metaProfileInit = StaticServiceController.getServiceController().getProfileModule().getMetaProfileInit();
        return new MetaProfileInitAction(metaProfileInit);
    }
}

package ariol.nylers.asbcore.core.gui.alpha.button.playerIsland;

import ariol.nylers.asbcore.core.gui.alpha.menu.playerIsland.PlayerIslandMenu;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.button.OpenMenuFactoryButton;
import io.neris.NGui.core.gui.button.controller.ButtonController;
import io.neris.NGui.core.gui.button.controller.SimpleBtnController;
import io.neris.NGui.core.gui.button.controller.actions.CancelPutAction;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import io.neris.NGui.core.gui.menu.services.PlayerMenuOpener;
import io.neris.NGui.core.services.StaticMenuServiceController;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class BtnToPlayerIsland extends OpenMenuFactoryButton {

    public BtnToPlayerIsland(ButtonRenderContext renderContext, PlayerIsland playerIsland) {

        ButtonController btnController = buildController(playerIsland);
        btnController.addAction(new CancelPutAction());
        PlayerMenuOpener menuOpener = getMenuOpener();
        MenuFactory<ClickEventContext> menuFactory = new PlayerIslandMenu(playerIsland);
        super(btnController, renderContext, menuOpener, menuFactory);
    }


    private static ButtonController buildController(PlayerIsland playerIsland){
        ButtonController btnController = new SimpleBtnController(
                Material.PAINTING, 1, Component.text("PlayerIsland: " + playerIsland.getId().toString()));
        btnController.addAction(new CancelPutAction());

        return btnController;
    }

    private static PlayerMenuOpener getMenuOpener(){
        return StaticMenuServiceController.getServiceController().getPlayerMenuOpener();
    }

}

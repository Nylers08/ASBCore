package ariol.nylers.asbcore.core.gui.alpha.button;

import ariol.nylers.asbcore.core.gui.alpha.menu.PlayerIslandMenuFactory;
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

    public BtnToPlayerIsland(ButtonRenderContext renderContext) {

        ButtonController btnController = buildController();
        PlayerMenuOpener menuOpener = getMenuOpener();
        MenuFactory<ClickEventContext> menuFactory = buildMenuFactory();

        super(btnController, renderContext, menuOpener, menuFactory);
    }


    private static ButtonController buildController(){
        ButtonController btnController = new SimpleBtnController(
                Material.GRASS_BLOCK, 1, Component.text("PlayerIsland"));
        btnController.addAction(new CancelPutAction());

        return btnController;
    }

    private static PlayerMenuOpener getMenuOpener(){
        return StaticMenuServiceController.getServiceController().getPlayerMenuOpener();
    }

    private static MenuFactory<ClickEventContext> buildMenuFactory(){
        return new PlayerIslandMenuFactory();
    }
}

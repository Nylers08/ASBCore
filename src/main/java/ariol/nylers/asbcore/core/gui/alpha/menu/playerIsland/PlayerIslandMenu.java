package ariol.nylers.asbcore.core.gui.alpha.menu.playerIsland;

import ariol.nylers.asbcore.core.gui.GuiUtils;
import ariol.nylers.asbcore.core.gui.alpha.button.playerIsland.BtnPlayerIslandPlace;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.button.Button;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.menu.BaseMenu;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import net.kyori.adventure.text.Component;

public class PlayerIslandMenu implements MenuFactory<ClickEventContext> {

    private final PlayerIsland playerIsland;

    public PlayerIslandMenu(PlayerIsland playerIsland) {
        this.playerIsland = playerIsland;
    }

    @Override
    public String getMenuName() {
        return "PlayerIslandMenu";
    }

    @Override
    public Menu create(ClickEventContext context) {
        Menu menu = new BaseMenu(46, Component.text("PlayerIsland Cache"));
        ButtonRenderContext renderContext = GuiUtils.buildRenderContext(context);
        Button placeBtn = new BtnPlayerIslandPlace(renderContext, playerIsland);
        menu.setItem(placeBtn.getItem(), 0);

        return menu;
    }
}

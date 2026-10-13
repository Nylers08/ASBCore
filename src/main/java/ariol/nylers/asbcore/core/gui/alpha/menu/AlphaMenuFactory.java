package ariol.nylers.asbcore.core.gui.alpha.menu;

import ariol.nylers.asbcore.core.gui.alpha.button.playerIsland.BtnToPlayerIslandMain;
import ariol.nylers.asbcore.core.gui.alpha.button.profile.BtnToProfileMenu;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.button.Button;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.menu.BaseMenu;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import net.kyori.adventure.text.Component;

public class AlphaMenuFactory implements MenuFactory<ButtonRenderContext> {

    @Override
    public String getMenuName() {
        return "AlphaMenuFactory";
    }

    @Override
    public Menu create(ButtonRenderContext context) {
        Menu menu = new BaseMenu(27, Component.text("Alpha Menu"));

        Button toPlayerIslandBtn = new BtnToPlayerIslandMain(context);
        Button toProfileBtn = new BtnToProfileMenu(context);

        menu.setItem(toProfileBtn.getItem(), 0);
        menu.setItem(toPlayerIslandBtn.getItem(), 1);

        return menu;
    }
}

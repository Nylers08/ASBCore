package ariol.nylers.asbcore.core.gui.alpha.menu;

import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.menu.BaseMenu;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import net.kyori.adventure.text.Component;

public class PlayerIslandMenuFactory implements MenuFactory<ClickEventContext> {
    @Override
    public String getMenuName() {
        return "PlayerIslandMenuFactory";
    }

    @Override
    public Menu create(ClickEventContext context) {
        Menu menu = new BaseMenu(27, Component.text("PlayerIsland main"));

        return menu;
    }
}

package ariol.nylers.asbcore.core.gui.alpha.menu;

import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.menu.BaseMenu;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import net.kyori.adventure.text.Component;

public class ProfileMenuFactory implements MenuFactory<ClickEventContext> {


    @Override
    public String getMenuName() {
        return "ProfileMenuFactory";
    }

    @Override
    public Menu create(ClickEventContext context) {
        Menu menu = new BaseMenu(27, Component.text("Profile main"));

        return menu;
    }
}

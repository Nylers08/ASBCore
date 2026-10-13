package ariol.nylers.asbcore.core.gui.alpha.menu.profile;

import ariol.nylers.asbcore.core.gui.GuiUtils;
import ariol.nylers.asbcore.core.gui.alpha.button.profile.BtnProfileInit;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.button.Button;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
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

        ButtonRenderContext renderContext = GuiUtils.buildRenderContext(context);
        Button createProfileBtn = new BtnProfileInit(renderContext);

        menu.setItem(createProfileBtn.getItem(), 0);

        return menu;
    }
}

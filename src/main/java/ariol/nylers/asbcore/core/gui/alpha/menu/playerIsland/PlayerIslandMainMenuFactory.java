package ariol.nylers.asbcore.core.gui.alpha.menu.playerIsland;

import ariol.nylers.asbcore.core.gui.alpha.button.playerIsland.BtnPlayerIslandCreate;
import ariol.nylers.asbcore.core.gui.alpha.button.playerIsland.BtnToPlayerIslandCache;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.button.Button;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.menu.BaseMenu;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class PlayerIslandMainMenuFactory implements MenuFactory<ClickEventContext> {
    @Override
    public String getMenuName() {
        return "PlayerIslandMenuFactory";
    }

    @Override
    public Menu create(ClickEventContext context) {
        Menu menu = new BaseMenu(27, Component.text("PlayerIsland main"));

        Player player = (Player) context.whoClicked;
        ButtonRenderContext renderContext = new ButtonRenderContext(player.getUniqueId());
        Button toCache = new BtnToPlayerIslandCache(renderContext);
        Button piCreateBtn = new BtnPlayerIslandCreate(renderContext);

        menu.setItem(toCache.getItem(), 9);
        menu.setItem(piCreateBtn.getItem(), 0);

        return menu;
    }
}

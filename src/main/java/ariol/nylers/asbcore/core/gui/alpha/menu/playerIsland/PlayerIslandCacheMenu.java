package ariol.nylers.asbcore.core.gui.alpha.menu.playerIsland;

import ariol.nylers.asbcore.StaticServiceController;
import ariol.nylers.asbcore.core.gui.alpha.button.playerIsland.BtnToPlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandCacheController;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.button.Button;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.menu.BaseMenu;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayerIslandCacheMenu implements MenuFactory<ClickEventContext> {

    private final PlayerIslandCacheController cacheController;

    public PlayerIslandCacheMenu() {
        this.cacheController = StaticServiceController.getServiceController().getPlayerIslandCacheController();
    }

    @Override
    public String getMenuName() {
        return "PlayerIslandCacheMenu";
    }

    @Override
    public Menu create(ClickEventContext context) {
        Menu menu = new BaseMenu(27, Component.text("PlayerIsland Cache"));

        Collection<PlayerIsland> islands = cacheController.getAll();

        Player player = (Player) context.whoClicked;
        ButtonRenderContext renderContext = new ButtonRenderContext(player.getUniqueId());

        int i = 0;
        for (PlayerIsland island : islands){
            Button button = new BtnToPlayerIsland(renderContext, island);
            menu.setItem(button.getItem(), i++);
        }

        return menu;
    }
}

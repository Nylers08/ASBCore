package ariol.nylers.asbcore.core.gui;

import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import org.bukkit.entity.Player;

public class GuiUtils {

    public static ButtonRenderContext buildRenderContext(ClickEventContext clickEventContext){
        Player player = (Player) clickEventContext.whoClicked;
        return new ButtonRenderContext(player.getUniqueId());
    }
}

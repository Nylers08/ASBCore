package ariol.nylers.asbcore.core.gui.button.actions;

import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.controller.actions.ButtonAction;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.PlayerMenuOpener;

public abstract class ButtonToMenuAction implements ButtonAction {

    private final PlayerMenuOpener menuOpener;
    private final Menu menu;

    public ButtonToMenuAction(PlayerMenuOpener menuOpener, Menu menu) {
        this.menuOpener = menuOpener;
        this.menu = menu;
    }

    @Override
    public void execute(ClickEventContext clickContext) {
        menuOpener.open(clickContext.whoClicked, menu);
    }
}

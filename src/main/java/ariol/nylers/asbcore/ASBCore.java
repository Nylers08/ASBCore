package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.commands.ASBCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ASBCore extends JavaPlugin {

    private ServiceController serviceController;

    @Override
    public void onEnable() {
        // Plugin startup logic

        serviceController = new ServiceController();

        getCommand("isop").setExecutor(new ASBCommand(serviceController));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

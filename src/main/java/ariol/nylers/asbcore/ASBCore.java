package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.commands.ASBCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ASBCore extends JavaPlugin {

    @Override
    public void onEnable() {

        // Plugin startup logic

        getCommand("isop").setExecutor(new ASBCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.commands.ASBCommand;
import io.neris.NGui.NGui;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class ASBCore extends JavaPlugin {

    private ServiceController serviceController;
    private NGui nGui;

    @Override
    public void onEnable() {
        // Plugin startup logic

        Plugin plugin = Bukkit.getPluginManager().getPlugin("NGui");
        if(plugin instanceof NGui nguiInstance){
            nGui = nguiInstance;
        }

        serviceController = new ServiceController(nGui.getServiceController());


        getCommand("isop").setExecutor(new ASBCommand(serviceController));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

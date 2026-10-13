package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.commands.ASBCommand;
import io.neris.NGui.NGui;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

@Slf4j
public final class ASBCore extends JavaPlugin {

    private ServiceController serviceController;
    private NGui nGui;

    @Override
    public void onEnable() {
        // Plugin startup logic

        Plugin plugin = Bukkit.getPluginManager().getPlugin("NGui");

        if (plugin == null) {
            getLogger().severe("Плагин NGui не найден!");
        } else {
            getLogger().info("Найден плагин: " + plugin.getName());
            getLogger().info("Класс: " + plugin.getClass().getName());
            getLogger().info("Загружен: " + plugin.isEnabled());

            if (plugin instanceof NGui nguiInstance) {
                nGui = nguiInstance;
            } else {
                getLogger().severe("Найден NGui, но класс не совпадает!");
            }
        }

        serviceController = new ServiceController(nGui.getMenuServiceController());
        StaticServiceController.init(serviceController);


        getCommand("isop").setExecutor(new ASBCommand(serviceController));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

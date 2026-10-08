package ariol.nylers.asbcore.core.commands;

import ariol.nylers.asbcore.ServiceController;
import ariol.nylers.asbcore.core.profile.loaders.MetaProfileInit;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ASBCommand implements CommandExecutor {

    private final ServiceController serviceController;

    public ASBCommand(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        Player player = (Player) sender;
        MetaProfileInit metaProfileInit = serviceController.getProfileModule().getMetaProfileInit();
        metaProfileInit.init(player.getUniqueId());

        return true;
    }

    private Clipboard loadClipboard(File file) throws IOException {
        ClipboardFormat format = ClipboardFormats.findByFile(file);

        if (format == null) {
            throw new IOException("Unknown schematic format: " + file);
        }

        try (InputStream inputStream = Files.newInputStream(file.toPath());
             ClipboardReader reader = format.getReader(inputStream)) {

            return reader.read();
        }
    }
}

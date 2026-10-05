package ariol.nylers.asbcore.core.commands;

import ariol.nylers.asbcore.core.playerIsland.services.clipboardPlacer.ClipboardPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.posResolver.IslandPosResolver;
import ariol.nylers.asbcore.core.playerIsland.services.posResolver.PosResolverByPlayer;
import ariol.nylers.asbcore.core.playerIsland.services.posResolver.TestIslandPosResolver;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
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

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        Player player = (Player) sender;
        String schemName = "test";
        if(args.length>0){
            schemName = args[0];
        }
        String fileName = schemName+".schem";
        try {
            Clipboard clipboard = loadClipboard(new File("F:\\Neris\\servers\\hub\\plugins\\FastAsyncWorldEdit\\schematics\\"+fileName));
            IslandPosResolver posResolver = new PosResolverByPlayer(player.getUniqueId());
            IslandLocalLocation localLocation = posResolver.resolve();
            ClipboardPlacer placer = new ClipboardPlacer();

            placer.place(localLocation.getWorldLocation(), clipboard)
                    .thenRun(()->player.sendMessage("Завершили вставку"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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

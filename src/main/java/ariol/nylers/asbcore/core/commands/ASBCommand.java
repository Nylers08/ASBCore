package ariol.nylers.asbcore.core.commands;

import ariol.nylers.asbcore.ServiceController;
import ariol.nylers.asbcore.core.gui.alpha.menu.AlphaMenuFactory;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import io.neris.NGui.core.gui.button.ClickEventContext;
import io.neris.NGui.core.gui.button.controller.renderers.ButtonRenderContext;
import io.neris.NGui.core.gui.menu.Menu;
import io.neris.NGui.core.gui.menu.services.MenuFactory;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


@Slf4j
public class ASBCommand implements CommandExecutor {

    private final ServiceController serviceController;

    public ASBCommand(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        Player player = (Player) sender;

        ButtonRenderContext renderContext = new ButtonRenderContext(player.getUniqueId());
        MenuFactory<ButtonRenderContext> menuFactory = new AlphaMenuFactory();
        Menu menu = menuFactory.create(renderContext);
        serviceController.getMenuController().getPlayerMenuOpener().open(player, menu);

//        serviceController.getProfileModule().getMetaProfileInit().init(player.getUniqueId());
//        ProfileModule profileModule = serviceController.getProfileModule();
//        MetaProfileCacheController metaProfileCacheController = profileModule.getMetaProfileCacheController();
//        ProfileId profileId = metaProfileCacheController.getSelectedMetaProfile(player.getUniqueId()).getProfileId();
//
//        IslandLocalLocation minPos = new IslandLocalLocation( -10, -999, -10);
//        IslandLocalLocation maxPos = new IslandLocalLocation( 10, 999, 10);
//        IslandRegion region = new IslandRegion(minPos, maxPos);
//        Location origin = player.getLocation();
//
//        Member member = new Member(profileId, MemberRole.MEMBER);
//        Membership membership = new Membership(member);
//
//        Clipboard clipboard;
//        try {
//            clipboard = loadClipboard(new File("F:\\Neris\\servers\\hub\\plugins\\FastAsyncWorldEdit\\schematics\\test.schem"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        IslandContext context = new IslandContext(clipboard, region, origin);
//        Island island = new Island(context, membership, new IslandSettings());
//
//        serviceController.getIslandPlacer().place(island);

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

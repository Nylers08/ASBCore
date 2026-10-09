package ariol.nylers.asbcore.core.commands;

import ariol.nylers.asbcore.ServiceController;
import ariol.nylers.asbcore.core.island.members.Member;
import ariol.nylers.asbcore.core.island.members.MemberRole;
import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.region.IslandRegion;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import ariol.nylers.asbcore.core.profile.ProfileId;
import ariol.nylers.asbcore.core.profile.loaders.MetaProfileInit;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import org.bukkit.Location;
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

        serviceController.getProfileModule().getMetaProfileInit().init(player.getUniqueId());
        ProfileId profileId = serviceController.getProfileModule().getProfileCaches().selectedMetaProfileRegistry().getSelectedProfileMetaData(player.getUniqueId()).getProfileId();

        Location origin = player.getLocation();
        IslandLocalLocation minPos = new IslandLocalLocation(origin, -10, -10, -10);
        IslandLocalLocation maxPos = new IslandLocalLocation(origin, 10, 10, 10);
        IslandRegion region = new IslandRegion(minPos, maxPos);

        Member member = new Member(profileId, MemberRole.MEMBER);
        Membership membership = new Membership(member);

        serviceController.getRegionPlacer().place(region, player.getWorld(), membership);

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

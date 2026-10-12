package ariol.nylers.asbcore.core.playerIsland.services.clipboard.provider;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import com.sk89q.worldedit.extent.clipboard.Clipboard;

import java.util.Optional;

public interface ClipboardProvider {

    Optional<Clipboard> find(ClipboardId clipboardId);
}

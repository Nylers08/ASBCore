package ariol.nylers.asbcore.core.playerIsland.services.clipboard.provider;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Optional;


public class TestClipboardProvider implements ClipboardProvider{

    @Override
    public Optional<Clipboard> find(ClipboardId clipboardId) {
        Clipboard clipboard;
        try {
            clipboard = loadClipboard(new File("F:\\Neris\\servers\\hub\\plugins\\FastAsyncWorldEdit\\schematics\\test.schem"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(clipboard);
    }

    private com.sk89q.worldedit.extent.clipboard.Clipboard loadClipboard(File file) throws IOException {
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

package ariol.nylers.asbcore.core.playerIsland.pojo.island.presets;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import lombok.Getter;
import org.bukkit.World;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IslandPlacementPreset {

    @Getter
    private final Map<World, ClipboardId> placementPreset = new HashMap<>();


    public void put(World world, ClipboardId clipboardId){
        placementPreset.put(world, clipboardId);
    }

    public void remove(World world){
        placementPreset.remove(world);
    }

    public int size(){
        return placementPreset.size();
    }

    public boolean contains(World world){
        return placementPreset.containsKey(world);
    }

    public boolean contains(ClipboardId clipboardId){
        return placementPreset.containsValue(clipboardId);
    }


    public ClipboardId getClipboardId(World world){
        return placementPreset.get(world);
    }

    public Collection<ClipboardId> getClipboardIds(){
        return placementPreset.values();
    }

    public Set<World> getWorlds(){
        return placementPreset.keySet();
    }

    public Set<Map.Entry<World, ClipboardId>> entrySet(){
        return placementPreset.entrySet();
    }
}

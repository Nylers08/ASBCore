package ariol.nylers.asbcore.core.playerIsland.pojo.island.presets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IslandPresets {

    private final Map<IslandPresetId, IslandPlacementPreset> presets = new HashMap<>();

    public void put(IslandPresetId presetId, IslandPlacementPreset preset){
        presets.put(presetId, preset);
    }

    public void remove(IslandPresetId presetId){
        presets.remove(presetId);
    }

    public int size(){
        return presets.size();
    }

    public boolean contains(IslandPresetId presetId){
        return presets.containsKey(presetId);
    }

    public boolean contains(IslandPlacementPreset preset){
        return presets.containsValue(preset);
    }


    public IslandPlacementPreset getPlacementPreset(IslandPresetId presetId){
        return presets.get(presetId);
    }

    public Set<IslandPresetId> getIds(){
        return presets.keySet();
    }

    public Collection<IslandPlacementPreset> getClipboardIds(){
        return presets.values();
    }

    public Set<Map.Entry<IslandPresetId, IslandPlacementPreset>> entrySet(){
        return presets.entrySet();
    }
}

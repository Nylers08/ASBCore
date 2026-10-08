package ariol.nylers.asbcore.core.island.services.profile.cache;

import ariol.nylers.asbcore.core.island.profile.MetaProfile;

import java.util.*;

public class MetaProfileCache {

    private final Map<UUID, List<MetaProfile>> metaDataMap = new HashMap<>();


    public void put(UUID playerId, MetaProfile metaData){
        metaDataMap.computeIfAbsent(playerId, i->new ArrayList<>()).add(metaData);
    }

    public void putAll(UUID playerId, Collection<MetaProfile> metaDataCollection){
        metaDataCollection.forEach(metaData->put(playerId, metaData));
    }

    public void remove(UUID playerId){
        metaDataMap.remove(playerId);
    }

    public void remove(MetaProfile metaData){
        UUID playerId = metaData.getPlayerUuid();
        List<MetaProfile> metaDataSet = metaDataMap.get(playerId);
        metaDataSet.remove(metaData);
        if(metaDataSet.isEmpty()){
            remove(playerId);
        }
    }


    public boolean has(UUID playerId){
        return metaDataMap.containsKey(playerId);
    }

    public boolean has(MetaProfile metaData){
        UUID playerId = metaData.getPlayerUuid();
        return metaDataMap.get(playerId).contains(metaData);
    }

    public boolean isEmpty(){
        return metaDataMap.isEmpty();
    }


    public List<MetaProfile> getMetaDataSet(UUID playerId){
        return metaDataMap.get(playerId);
    }
}

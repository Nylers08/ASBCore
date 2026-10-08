package ariol.nylers.asbcore.core;

import java.util.*;

public abstract class BiMultiMap<T1, T2> {

    private final Map<T1, T2> forward = new HashMap<>();
    private final Map<T2, Set<T1>> backward = new HashMap<>();


    public void put(T1 k, T2 v){
        forward.put(k, v);
        backward.computeIfAbsent(v, i-> new HashSet<T1>()).add(k);
    }

    public void put(T2 v, Set<T1> kSet){
        backward.put(v, kSet);
        kSet.forEach(first->forward.put(first, v));
    }

    public void putAll(Map<? extends T1, ? extends T2> map){
        forward.putAll(map);
        for (Map.Entry<? extends T1, ? extends T2> entry: map.entrySet()){
            put(entry.getKey(), entry.getValue());
        }
    }


    public void removeByKey(T1 k){
        T2 second = forward.get(k);
        forward.remove(k);
        removeFromBackward(k, second);
    }

    private void removeFromBackward(T1 k, T2 v){
        Set<T1> kSet = backward.get(v);
        kSet.remove(k);
        if(kSet.isEmpty()){
            backward.remove(v);
        }
    }

    public void removeByValue(T2 v){
        Set<T1> kSet = backward.get(v);
        kSet.forEach(forward::remove);
        backward.remove(v);
    }

    public void clear(){
        forward.clear();
        backward.clear();
    }


    public Set<T1> getKeySet(){
        return forward.keySet();
    }

    public Set<T2> getValues(){
        return backward.keySet();
    }


    public Set<Map.Entry<T1, T2>> getEntryForward(){
        return forward.entrySet();
    }

    public Set<Map.Entry<T2, Set<T1>>> getEntryBackward(){
        return backward.entrySet();
    }


    public Set<T1> getKeys(T2 v){
        return backward.get(v);
    }

    public T2 get(T1 k){
        return forward.get(k);
    }


    public boolean containsKey(T1 k){
        return forward.containsKey(k);
    }

    public boolean containsValue(T2 v){
        return backward.containsKey(v);
    }

    public boolean isEmpty(){
        return forward.isEmpty() && backward.isEmpty();
    }


    public int sizeKey(){
        return forward.size();
    }

    public int sizeValue(){
        return backward.size();
    }

}

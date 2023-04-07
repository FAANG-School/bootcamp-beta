package ru.faang.school.hashmap.task_1.Solution;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Container {
    private Map<String, House> map;

    public Container(){
        map = new HashMap<>();
    }

    public Container(Map<String, House> map){
        if(map == null) return;
        this.map = new HashMap<>();
        this.map.putAll(map);
    }

    public void add(String key, House value){
        map.put(key, value);
    }

    public void add(House h){
        map.put(h.getName(), h);
    }

    /**
     * @param key of element to be removed
     * @return true if specified element exists
     * and false otherwise
     */

    public boolean remove(String key){
        if(!map.containsKey(key))
            return false;
        map.remove(key);
        return true;
    }

    public boolean remove(House h){
        return remove(h.getName());
    }


    /**
     * @param key to find in map
     * @return null if key is not in the map
     */
    public String find(String key){
        if(!map.containsKey(key))
            return null;
        return map.get(key).getSigil();
    }

    public String find(House h){
        return find(h.getName());
    }


    /**
     *
     * @return false if there was IOException
     */
    public boolean showAll(){
        return showAll(System.out);
    }

    public boolean showAll(OutputStream s){
        for(Map.Entry<String, House> entry : map.entrySet())
            try {
                s.write(entry.getValue().toString().getBytes());
                s.write('\n');
            } catch(IOException ignored){
                return false;
            }
        return true;
    }

    /**
     * Equals and hashCode used only for unit tests
     * @param o object to compare with
     * @return true if object are equals to each other
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(map, container.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}

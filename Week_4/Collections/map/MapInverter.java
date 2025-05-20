package map;

import java.util.*;

public class MapInverter {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> inverted = invertMap(originalMap);
        System.out.println(inverted);
    }
}

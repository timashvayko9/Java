import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestLinkedHashMap {
    public static void main(String[] args) {

        Map<Integer,String> hashMap = new HashMap<>();// нету порядка
        Map<Integer,String> linkedHashMap = new LinkedHashMap<>();//гарантия порядка добавления пар(ключ, значение) в порядке добавления
        Map<Integer,String> treemap = new TreeMap<>();//гарантия сортировки по ключу

        testMap(treemap);
    }

    public static void testMap(Map<Integer,String> map){
        map.put(39,"Bob");
        map.put(12,"Mike");
        map.put(78,"Tom");
        map.put(0,"Tim");
        map.put(1500,"Lewis");
        map.put(7,"Bob");

        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());

        }
    }

}

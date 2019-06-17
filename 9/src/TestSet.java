import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();


        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);


       //union-объединение
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);

        //intersectiom-пересечение
        Set<Integer> intersectiom = new HashSet<>(set1);
        intersectiom.retainAll(set2);
        System.out.println(intersectiom);


        //difference-разность
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference);
    }

}

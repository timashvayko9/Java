import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        List<String> animals = new ArrayList<>();
//
//        animals.add("dog");
//        animals.add("cat");
//        animals.add("frog");
//        animals.add("bird");
//
//        Collections.sort(animals, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//
//                if(o1.length()> o2.length()){
//                    return 1;
//                } else if (o1.length()< o2.length()){
//                    return -1;
//                } else{
//                    return 0;
//                }
//            }
//        });
//        System.out.println(animals);
//
//
//        List<Integer> numbers = new ArrayList<>();
//
//        numbers.add(5);
//        numbers.add(500);
//        numbers.add(0);
//        numbers.add(100);
//
//        Collections.sort(numbers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//
//                if(o1>o2){
//                    return -1;
//                }else if (o1<o2){
//                    return 1;
//                }else {
//                    return 0;
//                }
//            }
//        });
//        System.out.println(numbers );
        List<Person> people = new ArrayList<>();
        people.add(new Person(3,"Mike"));
        people.add(new Person(1,"Bobby"));
        people.add(new Person(1,"Katy"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId()<o2.getId()){
                    return -1;
                } else if (o1.getId()>o2.getId()){
                    return 1;
                }else{
                    if(o2.getName().length()>o1.getName().length()){
                        return -1;
                    } else if(o1.getName().length()>o2.getName().length()){
                        return 1;
                    }else return 0;
                }
            }
        });

        System.out.println(people);
    }
}

class Person{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}









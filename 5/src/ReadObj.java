import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadObj {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin"))) {

            Person person1 = (Person) ois.readObject();
            System.out.println(person1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -5763287906308317851L;
    private int id;
    private String personName;
    private String surname;
    private int age;
    private byte type;


    public Person(int id,String name,String surname){
        this.id = id;
        this.personName = name;
        this.surname = surname;
    }

    public String getSurname(){return surname;}

    public String getName() {
        return personName;
    }

    public int getId() {
        return id;
    }
     public String toString(){
        return id +":" + personName +":"+surname;
     }
}

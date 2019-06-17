

interface AbleTOEat{
    public void eat();
}

public class Test {
    public static void main(String[] args) {
        AbleTOEat ableTOEat = new AbleTOEat() {
            @Override
            public void eat() {
                System.out.println("someone is eating");
            }
        };

        ableTOEat.eat();
    }
}
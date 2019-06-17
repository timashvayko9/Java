import java.util.Arrays;

public class MyLinkedList {

    private Node head;
    private int size;


    public void add(int value){
       //first add to list
        if(head == null){
           this.head = new Node(value);
       } else{
            Node tmp = head;


            while (tmp.getNext()!= null){
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node(value));
        }
        size++;
    }

    public String toString(){
        int[] result = new int[size];
        int idx = 0;
        Node tmp = head;

        while(tmp != null){
            result[idx++] = tmp.getValue();
            tmp = tmp.getNext();
        }
        return Arrays.toString(result);
    }

    public int get(int index){
        int currentIndex = 0;
        Node tmp = head;
        while(head != null){
            if(currentIndex == index){
                return tmp.getValue();
            }else {
                tmp = tmp.getNext();
                currentIndex++;
            }
        }

        throw new IllegalArgumentException();

    }

    public void remove(int index){
        if(index ==0){
            head = head.getNext();
            size--;
            return;
        }

        int currentIndex = 0;
        Node tmp = head;

        while(tmp !=  null){
            if((currentIndex+1) == index){
                tmp.setNext(tmp.getNext().getNext());
                size--;
                return;
            }else{
                tmp = tmp.getNext();
                currentIndex++;
            }
        }

    }

    private static class Node{
        private Node next;
        private int value;
        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

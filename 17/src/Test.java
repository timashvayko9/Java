public class Test {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        MyThread1 myThread1 = new MyThread1();
//        myThread1.start();

        Thread thread = new Thread(new Runner());
        thread.start();
    }
}

class Runner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            try{
                Thread.sleep(0);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Hello from my Thread "+i);
    }
}

class MyThread extends Thread{

    public void run(){
        for (int i = 0; i <1000 ; i++) {
            try{
                Thread.sleep(0);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Hello from my Thread "+i);
        }
    }
}

class  MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("1111111111111111111111 " + i);
        }
    }
}}



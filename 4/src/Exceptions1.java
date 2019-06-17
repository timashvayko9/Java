import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Exceptions1 {
    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        while(true){
          int x = Integer.parseInt(scanner.nextLine());

          if ( x!=0){
              throw new ScannerException("Users in smth against zero");
          }
        }
    }
}

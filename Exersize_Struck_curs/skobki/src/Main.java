import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final char q = '(';
    private static final char w = ')';
    private static final char a = '{';
    private static final char s = '}';
    private static final char z = '[';
    private static final char x = ']';

    public static void main(String[] args) {

        boolean a = true;

            System.out.println("X:");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("STR:");
                    Scanner scanner = new Scanner(System.in);
                    String str = scanner.nextLine();
                    if (isBalanced(str)) {
                        System.out.println("Succes");
                    } else  if (!isBalanced(str)){
                        System.out.println("wrong");
                    }
                    break;
                case 2:
                        if(isBalanced("{[]}()()(())()()(())")){
                            System.out.println("Succes");
                        }else {
                            System.out.println("wrong");
                        }
                    if(isBalanced("(1(2)3)4(5(6)7)")){
                        System.out.println("Succes");
                    }else {
                        System.out.println("wrong");
                    }
                    break;
            }
    }

    public static boolean isBalanced(String value){
        Stack stack = new Stack();

        char[] array = value.toCharArray();
        for (char c:array){
//            if((c =='(' || c == '{' || c == '[')) {
//                stack.push(c);
//            } else if(stack.empty()) {
//                return false;
//            }
//
//            char t = (char) stack.pop();
//            if ((t == '[' & c != ']') || (t == '{' & c != '}') || (t == '(' & c != ')')){
//                return false;
//            }
//
//            return stack.empty();
            if((c == w || c == s || c == x ) && stack.empty()){
                return false;
            }
            if((c == q || c == a || c == z)){
                stack.push(c);
            }
            if ((c == w || c == s || c == x) && !stack.empty()){
                char t = (char) stack.peek();
                switch (c) {
                    case ')':
                        if (t == '(') stack.pop();
                        break;

                    case ']':
                        if (t == '[') stack.pop();
                        break;
                    case '}':
                        if (t == '{') stack.pop();
                        break;
                }

            }

        }

        if(stack.empty()){
            return true;
        }else
        return false;
    }
}


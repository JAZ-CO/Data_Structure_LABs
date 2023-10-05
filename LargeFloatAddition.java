// ID: 202154790 Name: Jalal Zainaddin
import java.util.Stack;
import java.util.Scanner;
public class LargeFloatAddition {
    static String LargeFloatAddition(String firstFloat, String secondInteger) {
        // Same of operation using Integer Stacks
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> resultStack = new Stack<Integer>();

        // below is what made a difference between integer and float addition
        // in float, we add everything like an integer, but we add a decimal '.' in correct position
        // we compare the index of dot '.' between first and second, to take the larger
        int decimalInd = firstFloat.indexOf(".") > secondInteger.indexOf(".") ? firstFloat.indexOf("."):secondInteger.indexOf(".");


        for(int k = 0; k < firstFloat.length(); k++){
            // we check if the incoming character is only a digit, to avoid adding it to the stack
            if (firstFloat.charAt(k) != '.') {
                stack1.push(firstFloat.charAt(k) - '0');
            }
        }

        for(int k = 0; k < secondInteger.length(); k++){
            // we check if the incoming character is only a digit, to avoid adding it to the stack
            if (secondInteger.charAt(k) != '.') {
                stack2.push(secondInteger.charAt(k) - '0');
            }
        }

        // same procces as carry and sum using integers
        int sum = 0, carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
                sum = (carry + stack1.pop() + stack2.pop());
                resultStack.push( sum % 10);
                carry = sum / 10;

        }

        while (!stack1.isEmpty()) {
            sum = (carry + stack1.pop());
            resultStack.push(sum % 10);
            carry = sum / 10;
        }

        while (!stack2.isEmpty()) {
            sum = (carry + stack2.pop());
            resultStack.push(sum % 10);
            carry = sum / 10;
        }

        if(carry > 0)
            resultStack.push(carry);

        // we add an extra parameter for the decimal '.' index
        String thesum = convertStackContentsToString(resultStack, decimalInd);
        return thesum;
    }

    static String convertStackContentsToString(Stack<Integer> resultStack, int ind) {
        String str = "";
        while (!resultStack.isEmpty()){
            if (ind != 0){
            str = str + resultStack.pop();
            if (ind != -1)
                // decrement the index in order to reach zero
                ind--;
            }else {
                str += ".";
                // set the ind to -1 always.
                ind = -1;
            }
        }

        return str;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first floating point number:  ");
        String firstInteger = scanner.nextLine();
        System.out.print("Enter the second floating point number: ");
        String secondInteger = scanner.nextLine();
        String sum = LargeFloatAddition(firstInteger, secondInteger);
        System.out.println("Sum = " + sum);
    }
} 
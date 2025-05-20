public class StringUtils {
    public String revString(String input){
        String reversed = new StringBuilder(input).reverse().toString();
        return reversed;
    }

    public boolean palindrome(String input){
        String palindrome = new StringBuilder(input).reverse().toString();
        boolean res = false;
        if(input.equals(palindrome)){
            res = true;
        }
        return res;
    }

    public  String toUpper(String input){
        String res = input.toUpperCase();
        return res;
    }
}

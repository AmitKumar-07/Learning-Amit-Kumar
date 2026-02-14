
import java.util.*;

public class Main {
        public static void main(String[] args) throws Exception {

            String n1 = "amit";
            String n2 = new String(" kumar");
            String t = n1 + n2;
            System.out.println(t.toUpperCase());

            Integer test = 12;
            System.out.println(test==new Integer(12));
            String str = "amaasasittt";
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String string = new String(arr);
            System.out.println(string);

        }

}
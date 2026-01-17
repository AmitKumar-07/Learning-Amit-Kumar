
import java.util.*;

public class Main {
        public static void main(String[] args) throws Exception {

            Map<Integer, String> mp = new HashMap<>();
            mp.put(12, "abc");
            mp.put(1, "bhu");
            mp.put(2, "iit");
            for(Map.Entry<Integer, String> ele : mp.entrySet()){
                if(ele.getKey()==2){
                    ele.setValue("nit");
                }
            }
            for(Map.Entry<Integer, String> ele : mp.entrySet()){
                System.out.println(ele.getValue());
            }

        }


}
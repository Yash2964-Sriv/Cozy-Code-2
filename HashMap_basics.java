import java.util.*;

public class HashMap_basics {
  public static void main(String args[]){

    HashMap<Integer, String> m = new HashMap<>();

    //Add elements using put method
    m.put(2, "Yash");
    m.put(3, "Yashi");
    m.put(4, "Yash");
    m.put(5, "Yasha");

    // Iterate the map using for-each loop
    for (Map.Entry<Integer, String> e : m.entrySet()){ 
            System.out.println("Key: " + e.getKey()
                               + " Value: " + e.getValue());
    }

    for(Integer key : m.keySet()){
        System.out.println("Key:"+key);
    }
    for(String value : m.values()){
        System.out.println("Value:"+value);
    }

  }
    
}

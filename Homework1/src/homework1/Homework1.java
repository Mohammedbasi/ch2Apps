package homework1;

import java.util.ArrayList;
import java.util.List;

public class Homework1 {

    public static void main(String[] args) { 
        
        Addition<Integer> add = (a, b) -> {
            return a + b;
        };
        System.out.println("Addition number : "+add.add(50, 20));

        Addition<String> add2 = (s1, s2) -> {
            return s1 + s2;
        };
        System.out.println("Addition string : "+add2.add("helo", " world"));
        
        System.out.println("use lambda with list");
        
        List<String> list=new ArrayList<>();
        list.add("mohammed");  
        list.add("ahmed");  
        list.add("salem");  
        list.add("othman");
        list.forEach(
        (n)->System.out.println(n)
        );

    }

    private interface Addition<T> {
        T add(T a, T b);
    }

}

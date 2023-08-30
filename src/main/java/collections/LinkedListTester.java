package collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTester {
    public static void main(String[] args) {

        List<String> strs = new LinkedList<>();
        strs.add("A");
        strs.add("B");
        strs.add("C");

        System.out.println(strs.get(strs.size()-1));

        strs.add(1,"X");
        System.out.println(strs.size());

    }
}

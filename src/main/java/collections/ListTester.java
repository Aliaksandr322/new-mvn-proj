package collections;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTester {
    public static void main(String[] args) {
        List<Cat> listOfCats = new ArrayList<>();
        listOfCats.add(new Cat());

        Cat cat = new Cat();
        cat.setName("Tom");
        listOfCats.add(cat);
        listOfCats.addAll(Arrays.asList(new Cat(),new Cat(),new Cat()));
        System.out.println("listOfCats size" + listOfCats.size());


        List rawList = new ArrayList();
        rawList.add(1);
        rawList.add(1);
        rawList.add(new Cat());
        rawList.add("Tom");
        rawList.add(new StringBuilder());
        rawList.add(new Object());

        System.out.println("Raw list size " + rawList.size());

        rawList.get(2);
    }
}
@Data
class Cat {
    private int id;
    private String name;
}

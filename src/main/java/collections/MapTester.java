package collections;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapTester {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();

        map1.put(123, "John");
        map1.put(125, "Mike");
        System.out.println(map1.size());

        map1.forEach((k,v) -> {
            System.out.println("Key: " + k + " ,Value : " + v);
        });

        Map<Passport, Human> map2 = new HashMap<>();
        map2.put(new Passport("MP124312",new Date()), new Human("Bob", "JJ",50));
        map2.put(new Passport("MP1247312",new Date()), new Human("Mike", "JJ",50));
        map2.put(new Passport("MP1214312",new Date()), new Human("Jack", "nm",50));
        map2.put(new Passport("MP1243112",new Date()), new Human("Bob", "JJ",50));
        map2.put(new Passport("MP12473122",new Date()), new Human("Mike", "JJ",50));
        map2.put(new Passport("MP1243132",new Date()), new Human("Bob", "JJ",50));
        map2.put(new Passport("MP12473142",new Date()), new Human("Mike", "JJ",50));
        map2.put(new Passport("MP1243125",new Date()), new Human("Bob", "JJ",50));
        map2.put(new Passport("MP12473612",new Date()), new Human("Mike", "JJ",50));
        map2.put(new Passport("MP1243127",new Date()), new Human("Bob", "JJ",50));
        map2.put(new Passport("MP12473812",new Date()), new Human("Mike", "JJ",50));
        map2.put(new Passport("MP1243192",new Date()), new Human("Bob", "JJ",50));
        map2.put(new Passport("MP124731002",new Date()), new Human("Mike", "JJ",50));

        System.out.println(map2.get(new Passport("MP1214312",new Date())).name);

        for (Map.Entry<Passport, Human> entry : map2.entrySet()){
            Passport passport = entry.getKey();
            Human human = entry.getValue();
        }


        Map<Human, Map<Passport, Human>> map3 = new HashMap<>();
        map3.put(new Human("Alex", "AA", 18), map2);
        for (Map.Entry<Human ,Map<Passport, Human>> entry : map3.entrySet()){
            Human empl = entry.getKey();
            Map<Passport, Human> scope = entry.getValue();
            System.out.println("Notify: ");
                for (Map.Entry<Passport, Human> entry1 :scope.entrySet()){
                    System.out.println(entry1.getValue().name + " please take your passport with id: " + entry1.getKey().id);
                }

        }


    }
}


class Passport{
    String id;
    Date exp;

    public Passport(String id, Date exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id) && Objects.equals(exp, passport.exp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exp);
    }
}

class Human{
    public Human(String name, String lName, int age) {
        this.name = name;
        this.lName = lName;
        this.age = age;
    }
    String name;
    String lName;
    int age;
}
package model;

public class ClonePersonTest {

    public static void main(String[] args) {
        Person p1 = new Person(123, "John", "Johnos", 43);
        Person p2 = new Person(123, "John", "Johnos", 43);

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());

        Person p3 = new Person(222, "Bob", "Bobson", 54);
        Person p4 = new Person();
        // copy field to field
        p4.setId(p3.getId());
        p4.setAge(p3.getAge());
        p4.setLastName(p3.getLastName());
        p4.setName(p3.getName());
        p4.setCat(p3.getCat());

        System.out.println("Clone correct ? " + p3.equals(p4));

        Person p6 = new Person(555, "Mike", "Tyson", 57, null);
        Person p7 = p6.clone();
        System.out.println(p6.equals(p7));

    }

}

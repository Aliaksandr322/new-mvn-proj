package model;

public class PersonEqualsTests {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("John");
        p1.setLastName("Johnson");
        p1.setAge(55);
        p1.setId(100);

        Person p2 = new Person(100,"John","Johnson",55);

        // 1.
        System.out.println("p1 == p2 " + (p1 == p2));

        Person p100 = p1;
        System.out.println("p100 == p1 " + (p100 == p1));

        // 2 equals - по умолчанию проверяет ссылки
        // если не переопрелеоить equals всегда будут сравниваться ссылки
        Cat cat1 = new Cat("Murzik");
        Cat cat2 = new Cat("Murzik");

        Person person1 = new Person(123,"Mike","Tyson",56);
        person1.setCat(cat1);
        Person person2 = new Person(123,"Mike","Tyson",56);
        person2.setCat(cat2);

        // Для того чтобы объекты сравенивались корректно необходимр переопределить метод equals.
        // Как правило объекты сравниваются по полям.
        System.out.println("person1 equals person2 ? " + person1.equals(person2));

        // HashCode - функция которая вернет целое число
        System.out.println("cat1 hashCode : " + cat1.hashCode());
        System.out.println("cat2 hashCode : " + cat2.hashCode());

        System.out.println("person1 hashCode : " + person1.hashCode());
        System.out.println("person2 hashCode : " + person2.hashCode());
    }
}

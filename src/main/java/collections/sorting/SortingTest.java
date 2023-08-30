package collections.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Car;
import model.Person;

import java.util.*;

public class SortingTest {

    public static void main(String[] args) {


        Person p1 = new Person(123, "Mike", "Jackson", 40);
        Person p2 = new Person(21, "John", "Ivanov", 35);
        Person p3 = new Person(241, "Bob", "Petrov", 77);
        Person p4 = new Person(54, "Alex", "Tyson", 21);
        Person p5 = new Person(656, "Alexis", "Sidorov", 14);
        Person p6 = new Person(234, "Mary", "Smi", 2);

        Car c1  = new Car(33,"BMW");
        Car c2  = new Car(45,"Acura");
        Car c3  = new Car(12,"Audi");
        Car c4  = new Car(32,"Tesla");
        Car c5  = new Car(1,"BMW 3");
        Car c6  = new Car(100,"BMW 4");

        p1.setCar(c1);
        p2.setCar(c2);
        p3.setCar(c3);
        p4.setCar(c4);
        p5.setCar(c5);
        p6.setCar(c6);

        List<Person> personList = Arrays.asList(p1,p2,p3,p4,p5,p6);

        // 1st via Comparable
        System.out.println(personList);
        Collections.shuffle(personList);
        System.out.println(personList);
        Collections.sort(personList);
        System.out.println(personList);
        personList.forEach(elem ->{
            System.out.println(elem.getLastName());
        });

        List<String> strs = Arrays.asList("BB","AAA", "AA","Y" ,"CC");
        Collections.sort(strs);
        System.out.println(strs);

        List<Car> cars = Arrays.asList(new Car(), new Car());
        Collections.sort(cars);

        // 2nd via Comparator
        Collections.sort(personList,new PersonsByCarsIdComparator());
        System.out.println(personList);
        personList.forEach(elem ->{
            System.out.println(elem.getCar().getId());
        });
        Collections.sort(personList,new PersonsByCarsModelComparator());
        System.out.println(personList);
        personList.forEach(elem ->{
            System.out.println(elem.getCar().getModel());
        });


        Collections.sort(personList,new PersonsByAgeComparator());
        System.out.println(personList);
        personList.forEach(elem ->{
            System.out.println(elem.getAge());
        });

        Pizza pizza1 = new Pizza("Cheese", 's',true,1110);
        Pizza pizza2 = new Pizza("Veggien", 's',true,500);
        Pizza pizza3 = new Pizza("Pepperoni", 's',true,1120);
        Pizza pizza4 = new Pizza("Pepperoni", 'l',true,2000);

        List<Pizza> pizzaList = Arrays.asList(pizza1,pizza2,pizza3,pizza4);

        Collections.sort(pizzaList);
        System.out.println(pizzaList);
        Collections.sort(pizzaList,PizzaCompareByName.BY_NAME);
        System.out.println(pizzaList);
    }

}
class PersonsByCarsIdComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        System.out.println("PersonsCarComparator -> compare");
        return o1.getCar().compareTo(o2.getCar());
    }
}
class PersonsByCarsModelComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        System.out.println("PersonsCarComparator -> compare");
        return o1.getCar().getModel().compareTo(o2.getCar().getModel());
    }
}

class PersonsByAgeComparator implements Comparator<Person>{

    private boolean asc = true;
    public PersonsByAgeComparator(boolean asc ){
        this.asc = asc;
    }
    public PersonsByAgeComparator(){

    }
    @Override
    public int compare(Person o1, Person o2) {
        return asc ?
                new Integer(o1.getAge()).compareTo(o2.getAge())
                :
                new Integer(o2.getAge()).compareTo(o1.getAge()) ;
    }
}
@Data
@AllArgsConstructor
class Pizza implements Comparable<Pizza>{
    private String name;
    private char size; // can be 's', 'm', 'l'
    private boolean isThin;
    private long kcal;

    @Override
    public int compareTo(Pizza o) {
        return Long.valueOf(this.getKcal()).compareTo(o.getKcal());
    }


}
class PizzaCompareByName implements Comparator<Pizza>{

    public static PizzaCompareByName BY_NAME = new PizzaCompareByName();

    private PizzaCompareByName(){}

    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

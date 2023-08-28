package collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

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

        List<Cat> cats = new ArrayList<>(Arrays.asList(new Cat(),new Cat(),new Cat()));
        cats.addAll(listOfCats);
        cats.remove(cats.size() - 1);
        System.out.println(cats.size());

        //
        Student student1 = new Student(23, "Mike",7.8);
        Student student2 = new Student(99, "John",9.8);
        Student student3 = new Student(13, "Bill",6.2);
        List<Student> group1 = new ArrayList<>(Arrays.asList(student1,student2,student3));

        group1.add(student2);

        System.out.println("First student in list : " + group1.get(0));
        System.out.println("Last student in list : " + group1.get(group1.size() - 1));
        Student justRemoved = group1.remove(2);
        System.out.println("Removed : " + justRemoved);

        group1.remove(student2);

        group1.removeAll(Arrays.asList(new Student(1, "Alex", 7.2),
                new Student(2 , "Bob", 7.2),
                new Student(23, "Mike",7.8)));

        group1.add(new Student(2 , "Bob", 7.2));
        group1.add(new Student(23, "Mike",9.8));
        group1.add(new Student(1, "Alex", 7.2));
        group1.add(new Student(2 , "Bob", 7.2));
        group1.add(new Student(1313, "Mike",5.8));
        group1.add(new Student(1, "Alex", 7.2));
        group1.add(new Student(513 , "Bob", 6.2));
        group1.add(new Student(23, "Mike",9.8));
        group1.add(new Student(1, "Alex", 7.2));

        // walk
        for (int i = 0; i < group1.size(); i++){
            Student st = group1.get(i);
            if (st.getAvg() >= 8){
                System.out.println(st.getName().toUpperCase());
            }
        }
        List<Student> listToRemove = new ArrayList<>();
        for (Student s : group1){
            if (s.getAvg() < 7){
                listToRemove.add(s);
            }
        }
        group1.removeAll(listToRemove);
        System.out.println("Left : " + group1);

        group1.forEach( elem -> {
            System.out.println(elem.getName() + " : " + elem.getAvg());
        });

        // Iterator
        Iterator<Student> interator= group1.iterator();
        while (interator.hasNext()){
            Student s = interator.next();
            if(s.getName().startsWith("J")) {
                interator.remove();
                System.out.println("Student deleted " + s.getId());
            }
        }
        System.out.println("Left : " + group1);

        for (Iterator<Student> iter= group1.iterator();iter.hasNext();){
            System.out.println(iter.next().toString().toUpperCase());
        }

        group1.sort(new studentComparator(false));
        group1.forEach (e -> {
            System.out.println(e);
        });

        List<Cat> catsList = new ArrayList<Cat>(Arrays.asList(new Cat("Black", 12), new Cat("Red", 2),new Cat("Black", 32)));
        Iterator<Cat> catIterator = catsList.iterator();
        while (interator.hasNext()){
            Cat c = catIterator.next();
            if (c.getColor().equals("Black")){
                catsList.remove(c);
            }
        }
        System.out.println(catsList);


    }
}

class studentComparator implements Comparator<Student>{

    private boolean asc;//desc
    public studentComparator(boolean asc){
        this.asc = asc;
    }

    @Override
    public int compare(Student o1, Student o2) {
        System.out.println(" compare -> ");
        if(o1.getAvg() == o2.getAvg()) return 0;
        else if(o1.getAvg() > o2.getAvg()) return asc ? 1 : -1;
        else return asc ? -1 : 1;
    }
}

@Data
@NoArgsConstructor
class Cat {
    private int id;
    private String name;
    private String color;
    private int age;

    public Cat(String color, int age) {
        this.color = color;
        this.age = age;
    }
}

@Data
@AllArgsConstructor
class Student {
    private int id;
    private String name;
    private double avg;
}
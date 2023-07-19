package generics;

import model.Dog;

public interface Pair <K, V>{
    K getKey();
    V getValue();
    default void print(){
        System.out.println(getKey() + " : " + getValue());
    }
}

class Assoc <K, V> implements Pair <K, V>{

    private K key;
    private V value;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public void setKey (K key){
        this.key = key;
    }
    public void setValue(V value){
        this.value = value;
    }

    public Assoc(K key, V value) {

        this.key = key;
        this.value = value;
    }
}

class PairTest{
    public static void main(String[] args) {
        Assoc<String ,String> assoc1 = new Assoc<>("Main", "Главный");
        Assoc<String ,String> assoc2 = new Assoc<>("Cat", "Кот");
        Assoc<String ,String> assoc3 = new Assoc<>("Dog", "Песик");

        System.out.println(assoc2.getValue());
        assoc1.print();

        Storage<Assoc<String, String>> assocStorage = new Storage<>();
        assocStorage.add(assoc1);
        assocStorage.add(assoc2);
        assocStorage.add(assoc3);

        System.out.println(assocStorage.get(2).getValue());

        Assoc<Integer, String> numbers1 = new Assoc("1", "One");
        Assoc<Integer, String> numbers2 = new Assoc("2", "Two");
        Assoc<Integer, String> numbers3 = new Assoc("3", "Three");
        Assoc<Integer, String> numbers4 = new Assoc("4", "Four");
        Assoc<Integer, String> numbers5 = new Assoc("5", "Five");
        Assoc<Integer, String> numbers6 = new Assoc("6", "Six");
        Assoc<Integer, String> numbers7 = new Assoc("7", "Seven");
        Assoc<Integer, String> numbers8 = new Assoc("8", "Eight");
        Assoc<Integer, String> numbers9 = new Assoc("9", "Nine");


        Storage<Assoc<Integer, String>> english = new Storage<>();
        english.add(numbers1);
        english.add(numbers2);
        english.add(numbers3);
        english.add(numbers4);
        english.add(numbers5);
        english.add(numbers6);
        english.add(numbers7);
        english.add(numbers8);
        english.add(numbers9);


        Assoc<Integer, String> numbers11 = new Assoc("1", "Один");
        Assoc<Integer, String> numbers12 = new Assoc("2", "Два");
        Assoc<Integer, String> numbers13 = new Assoc("3", "Три");
        Assoc<Integer, String> numbers14 = new Assoc("4", "Четыре");
        Assoc<Integer, String> numbers15 = new Assoc("5", "Пять");
        Assoc<Integer, String> numbers16 = new Assoc("6", "Шесть");
        Assoc<Integer, String> numbers17 = new Assoc("7", "Семь");
        Assoc<Integer, String> numbers18 = new Assoc("8", "Восемь");
        Assoc<Integer, String> numbers19 = new Assoc("9", "Девять");

        Storage<Assoc<Integer, String>> russia = new Storage<>();
        english.add(numbers11);
        english.add(numbers12);
        english.add(numbers13);
        english.add(numbers14);
        english.add(numbers15);
        english.add(numbers16);
        english.add(numbers17);
        english.add(numbers18);
        english.add(numbers19);

        Assoc<String , Storage<Assoc<Integer,String>>> global1 = new Assoc<>("EN", english);
        Assoc<String , Storage<Assoc<Integer,String>>> global2 = new Assoc<>("RUS", russia);

        Storage<Assoc<String, Storage<Assoc<Integer, String>>>> globalStorage = new Storage<>();

        globalStorage.add(global1);
        globalStorage.add(global2);

        // достать цифру 2 дома

    }
}

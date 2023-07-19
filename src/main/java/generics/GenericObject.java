package generics;

public class GenericObject <T> {
    private T value;

    public GenericObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class GenericTest{
    public static void main(String[] args) {

        GenericObject<String> gen = new GenericObject<String>("ABC");

        String val = gen.getValue();

        GenericObject<Integer> gen2 = new GenericObject<Integer>(123);

        int val2 = gen2.getValue();
        gen2.setValue(56);// 56 -> new Integer(56)

        int i_1 = gen2.getValue();

        GenericObject<Boolean> gen3 = new GenericObject<>(true);


        Integer i = new Integer(155);
        Double d = new Double("1.4");
        System.out.println(d);
    }
}
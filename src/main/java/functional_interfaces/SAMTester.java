package functional_interfaces;


import java.util.Date;
import java.util.function.Function;

// 'SAM' <=> FunctionalInterface- Single Abstract Method Interfaces
public class SAMTester {

    static int counter = 0;
    int instanceCounter ;

    public static void main(String[] args) {

        //Anon class
        Operable op = new Operable() {
            @Override
            public void operation(int a, int b) {
                System.out.println(a - b);
            }
        };

        op.operation(100,20);

        //Lambda way
        int a_local = 50;
        Operable op3;
        op3 = (a,b) ->{
//            a_local = a_local + 6;
            System.out.println(a_local * b);
        };
        op3.operation(88,33);

        PrintAble pr1 = (str, times) -> {
            while (times > 0) {
                System.out.println(str);
                times--;
            }
        };

        pr1.print("Hello Lambda " , 3);

        Calculation c = () -> 1L;
        Calculation c2 = () -> 2L;
        Calculation c3 = () -> 3L;

        long value = c2.calc();
        System.out.println(value);

        test(c2);
        test(() -> 100L);

        Function<Double, Integer> function = (summa) -> {
            return (int)(3.25 * summa);
        };

        int result = function.apply(500.42);

        System.out.println(result);
    }
    static void test(Calculation c){
        System.out.println(c.calc() * 2);
    }
}
@FunctionalInterface
interface Calculation{
    long calc();
}


@FunctionalInterface
interface Operable{

    double PI = 3.14;

    void operation(int a, int b);

    default void defaultOperation(){
        System.out.println(new Date());
    }

    static void staticOperation(){
        System.out.println("Inside static");
    }
}
@FunctionalInterface
interface PrintAble{
    void print(String a, int times);
}

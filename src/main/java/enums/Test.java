package enums;

// import all static stuff
import static enums.Constants.*;

//import specific member
import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class Test {
    public static void main(String[] args) {
        cos(12);
        double x = PI + Constants.PI;
        System.out.println(Math.random());
        random(100);

        Problem problem1 = new Problem("Wrong password. ");
        problem1.resolve();


    }
    static int random(int bound){
        int x = (int)(Math.random() * bound);
        return x;
    }

}

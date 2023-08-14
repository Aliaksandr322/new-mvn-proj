package enums;

import java.util.Locale;
import java.util.Scanner;

public enum Seasons {

    WINTER, SPRING, SUMMER, AUTUMN;

    /*
       Choose 1, 2, 3, or 4
     */

    public static Seasons getSeasonByNumber(int number){
        switch (number){
            case 1:
                return SUMMER;
            case 2:
                return SPRING;
            case 3:
                return AUTUMN;
            case 4:
                return WINTER;
        }
        return null;
    }

    public static Seasons  getSeasonByMonthNumber(int number){
        switch (number){
            case 1:
            case 2:
            case 12:
                return WINTER;
            case 3:
            case 4:
            case 5:
                return SPRING;
            case 6:
            case 7:
            case 8:
                return SUMMER;
            case 9:
            case 10:
            case 11:
                return AUTUMN;
        }
        throw  new IllegalArgumentException("Incorrect month number " + number);

    }


}

class EnumTester{
    public static void main(String[] args) {

        Seasons s1 = Seasons.WINTER;

        switch (s1) {
            case SUMMER:
                System.out.println("Summer");
                break;
            case SPRING:
                System.out.println("");
                break;
            case WINTER:
                System.out.println("Best season ever!");
                break;
            case AUTUMN:
                System.out.println("Autumn");
                break;
            default:
                System.out.println(" =( ");
        }
        System.out.println(Seasons.valueOf("AUTUMN").ordinal());

        Scanner sc = new Scanner(System.in);
        System.out.println("Input month number (from 1 to 12) : ");
        int monthNumber = sc.nextInt();


        switch (Seasons.getSeasonByMonthNumber(monthNumber)) {
            case SUMMER:
                System.out.println("Summer");
                break;
            case SPRING:
                System.out.println("");
                break;
            case WINTER:
                System.out.println("Best season ever!");
                break;
            case AUTUMN:
                System.out.println("Autumn");
                break;
            default:
                System.out.println(" =( ");
        }



    }
}
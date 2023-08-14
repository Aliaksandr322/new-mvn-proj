package enums;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public enum Week {

    MONDAY(1,"mn"){
        @Override
        public void work() {
            System.out.println("Monday full working day");
        }
    },
    TUESDAY(2,"tu"){
        @Override
        public void work() {
            System.out.println("Tuesday full working day");
        }
    },
    WEDNESDAY(3,"wed"){
        @Override
        public void work() {
            System.out.println("Wednesday full working day");
        }
    },
    THURSDAY(4,"thd"){
        @Override
        public void work() {
            System.out.println("Thursday full working day");
        }
    },
    FRIDAY(5,"fr"){
        @Override
        public void work() {
            System.out.println("Friday full working day");
        }
    },
    SATURDAY(6,"sat"){
        @Override
        public void work() {
            System.out.println("Saturday is weekend");
        }
    },
    SUNDAY(7,"sun"){
        @Override
        public void work() {
            System.out.println("Sunday is weekend");
        }
    };

    private int numWeekDay;
    private String shortName;

    public int getNumWeekDay() {
        return numWeekDay;
    }

    public String getShortName() {
        return shortName;
    }

    public abstract void work();


    WeekDay getWeekDayByCode(String shortName){
        for (Week day : values()){
            if
        }
    }
}

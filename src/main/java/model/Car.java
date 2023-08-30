package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Comparable<Car> {
    private int id;
    private String model;

    @Override
    public int compareTo(Car o) {
//        if (this.id == o.getId()){
//            return 0;
//        }
//        else if (this.id > o.id){
//            return 1;
//        }
//        else return -1;

        return new Integer(this.id).compareTo(o.id);
    }
}

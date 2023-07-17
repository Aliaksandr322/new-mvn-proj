package util;

import errors.CarNotFoundException;
import model.Car;
import model.Person;
import org.junit.Test;

public class PersonsTest {
    @Test
    public void driveTest() throws CarNotFoundException {
        Person p1 = new Person();
        p1.setName("John");
        Car car = new Car();
        car.setModel("BMW X7");
        p1.setCar(car);

        PersonUtil.drive(p1);
    }

    @Test(expected = CarNotFoundException.class)
    public void driveTest1() throws CarNotFoundException {
        Person p1 = new Person();
        p1.setName("John");
        Car car = new Car();
        p1.setCar(car);

        PersonUtil.drive(p1);
    }
}

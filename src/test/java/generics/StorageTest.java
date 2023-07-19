package generics;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

public class StorageTest {
    @Test
    public void testStorage1(){
        Storage<Person> personStorage = new Storage<>();
        personStorage.add(new Person(12,"Bob","Ivanov",33));
        personStorage.add(new Person(22,"Mike","Ivanov",34));
        personStorage.add(new Person(33,"John","Ivanov",21));

        Assert.assertTrue(personStorage.size() == 3);
    }

    @Test(expected = NumberFormatException.class)
    public void testStorage2(){
        Storage<Number> numberStorage = new Storage<>();
        numberStorage.add(3.44);// boxing : (double)3.44 -> new Double(3.44) -> (Number)
        numberStorage.add(new Long(123));
        numberStorage.add(new Double("123,123"));
    }
    @Test()
    public void testStorage3(){
        Storage<String> strs = new Storage<>();
        strs.add("123");// boxing : (double)3.44 -> new Double(3.44) -> (Number)
        strs.add("Test");
        strs.add(new String(" "));
        String s = strs.get(strs.size() + 1);
        Assert.assertNull(s);
    }
}

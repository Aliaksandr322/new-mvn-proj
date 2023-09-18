package seria;

import lombok.Data;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerialTester {
    public static void main(String[] args) throws IOException {
        // Serialization in file
//        ObjectOutputStream oos =
//                new ObjectOutputStream(new FileOutputStream("D:\\io_tests\\tasks\\count_result.txt"));
//        Location l1 = new Location();
//        l1.setPostalCode(123);
//        l1.setAddress("BLR, Minsk, K. Marksa 32");
//        User u1 = new User();
//        u1.setId(111);
//        u1.setName("Bill");
//        u1.setLastName("Johnson");
//        u1.setPassword("12345678");
//        u1.setLocation(l1);
//
//        Location l2 = new Location();
//        l2.setPostalCode(123);
//        l2.setAddress("BLR, Minsk, K. Marksa 32");
//        User u2 = new User();
//        u2.setId(111);
//        u2.setName("Bill");
//        u2.setLastName("Johnson");
//        u2.setPassword("12345678");
//        u2.setLocation(l1);
//
//
//
//        Location l3 = new Location();
//        l3.setPostalCode(123);
//        l3.setAddress("BLR, Minsk, K. Marksa 32");
//        User u3 = new User();
//        u3.setId(111);
//        u3.setName("Bill");
//        u3.setLastName("Johnson");
//        u3.setPassword("12345678");
//        u3.setLocation(l1);
//
//        Location l4 = new Location();
//        l4.setPostalCode(123);
//        l4.setAddress("BLR, Minsk, K. Marksa 32");
//        User u4 = new User();
//        u4.setId(111);
//        u4.setName("Bill");
//        u4.setLastName("Johnson");
//        u4.setPassword("12345678");
//        u4.setLocation(l1);
//
//        oos.writeObject(Arrays.asList(u1, u2, u3, u4));
//        oos.close();
//        System.out.println(u1);

        //Deserialization (converting from bytes into Java Object)
        ObjectInputStream dis =
                new ObjectInputStream(new FileInputStream("D:\\io_tests\\tasks\\count_result.txt"));
        try {
            ((List) dis.readObject()).forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

@Data
class User implements Serializable {
    private transient String password;
    private transient String lastName;
    private final long serialVersionUID = 5810920551404927423L;
    private Location location;
    private int id;
    private String name;
}

@Data
class Location implements Serializable {
    private static final long serialVersionUID = -923793196155640491L;
    private String address;
    private int postalCode;
}

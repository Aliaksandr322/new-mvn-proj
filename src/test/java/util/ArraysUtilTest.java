package util;

import org.junit.*;

public class ArraysUtilTest {

    private int array[];

    @BeforeClass
    public static void init(){
        System.out.println("init job");
    }

    @Before
    public  void beforeEach(){
        System.out.println("beforeEach job");
        array = new int[5];
        array[0] =1;
        array[1] =3;
        array[2] =2;
        array[3] =-200;
        array[4] =3;

    }

    @AfterClass
    public static void destroy(){
        System.out.println("destroy / clean job");
    }

    @After
    public  void afterEach(){
        System.out.println("afterEach job");
    }

    @Test
    public void initialFindMaxTest(){
        System.out.println("initialFindMaxTest start");
        int expected = 3;
        int actual = ArraysUtil.findMax(array);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void arrayRemoveTest(){
        System.out.println("arrayRemoveTest start");
        array[1] = 0;
        int expected = 0;
        int actual = array[1];
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = NullPointerException.class )
    public void findMaxFromNullTest(){
        System.out.println("findMaxFromNullTest start");
        int actual = ArraysUtil.findMax(null);

    }

    @Test(timeout = 5000)
    public void generateArrayPerformance(){
        int max = 100_000;
        System.out.println(max);
        for (int i = 0 ; i < 10; i++){
            int [] bigArr = ArraysUtil.genRandomArray(max);
            ArraysUtil.printArray(bigArr);
        }


    }
}

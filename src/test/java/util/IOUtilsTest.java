package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class IOUtilsTest {

    @Test
    public void readFileTest(){
        String text = IOUtils.readFile("D:\\io_tests\\new_file.txt");

        Assert.assertNotNull(text);
        Assert.assertEquals("Wrong content", text , "Hello World!");
    }
    @Test
    public void readLargeFileTest(){
        String text = IOUtils.readFile("D:\\io_tests\\war_and_peace.txt");

        Assert.assertNotNull(text);
        Assert.assertTrue(text.length() > 100_000);
    }

    @Test
    public void writeFileTest(){
        String path = "D:\\io_tests\\new_file" + new Date().getTime() + ".txt";

        IOUtils.write("Hello from Java!" , path);
        IOUtils.write("Hello from Java!" , path, true);

        Assert.assertTrue(IOUtils.readFile(path).length() > 10);
    }

    @Test
    public void writeAppendFileTest(){
        String path = "D:\\io_tests\\new_append_file" + new Date().getTime() + ".txt";

        IOUtils.write("Hello from Java!" , path);
        IOUtils.write(" EXTRA TEXT" , path, true);
        Assert.assertEquals("Wrong content","Hello from Java! EXTRA TEXT",IOUtils.readFile(path));
    }

    @Test
    public void copyFiles(){
        String filePath1 = "D:\\io_tests\\first.txt";
        String filePath2 = "D:\\io_tests\\Second.txt";
        String filePath3 = "D:\\io_tests\\third.txt";

        IOUtils.copyFiles(filePath3,filePath1,filePath2);
        Assert.assertEquals("AB",IOUtils.readFile(filePath3));
    }


    @Test
    public void copyMultFilesTest(){
        String filePath1 = "D:\\io_tests\\A.txt";
        String filePath2 = "D:\\io_tests\\B.txt";
        String filePath3 = "D:\\io_tests\\C.txt";
        String filePath4 = "D:\\io_tests\\D.txt";
        String filePath5 = "D:\\io_tests\\E.txt";

        IOUtils.write("A",filePath1);
        IOUtils.write("B",filePath2);
        IOUtils.write("C",filePath3);
        IOUtils.write("D",filePath4);
        IOUtils.write("E",filePath5);

        String dstPath = "D:\\io_tests\\ABCDE.txt";

        IOUtils.createCopyFile(dstPath, filePath1,filePath2,filePath3,filePath4,filePath5);
        Assert.assertEquals("ABCDE",IOUtils.readFile(dstPath));
    }

    @Test
    public void fileContainWordTest(){
        
    }

}

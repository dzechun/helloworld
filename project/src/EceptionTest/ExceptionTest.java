package EceptionTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

/*
*一、异常体系结构
* Error:一般不编写针对的代码处理
* Exception:可以进行异常的处理
*   编译时异常：checked：IOException\ClassNotFoundException
*   运行时异常；unchecked:NullPointException\ArrayIndexOutOfBoundsException\ClassCastException
*
 */
public class ExceptionTest {
    //NullPointException
    @Test
    public void test1(){
        int[] arr = null;
        System.out.println(arr[3]);
    }
//ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        int[] arr = new int[10];
        System.out.println(arr[10]);
    }
//ClassCastException
    @Test
    public void test3(){
        Object obj = new Date();
        String str = (String)obj;
    }
//NumberFormatException
    @Test
    public void test4(){
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }
//InputMismatchException
    @Test
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
    }
//编译时异常
    @Test
    public void test6(){
        File file = new File("hello.txt");
//        FileInputStream fis = new FileInputStream(file);

    }
}

package java01;

import org.junit.Test;

/*
对比String\StringBuffer\StringBuild的效率
从高到低排列：StringBuilder>StringBuffer>String
 */
public class StingBufferBuildTest {
    @Test
    public void test1(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for(int i = 0;i < 20000;i++){
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for(int i = 0;i < 20000;i++){
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for(int i = 0;i < 20000;i++){
            text = text + 1;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间："+ (endTime - startTime));
    }
}

package StringDemo;

import org.junit.Test;

public class StringDemo1 {
    /*
    获取一个字符串在另一个字符串中出现的次数。
    比如：获取”ab“在"aokkcadkabkebfkabkskab"中出现的次数

     */
//    获取matchStr在Str中出现的次数
    public int getCount(String str,String matchStr){
        int strLength = str.length();
        int matchStrLength = matchStr.length();
        int count = 0;
        int index = 0;
        if(strLength >= matchStrLength){
            //first way
//            while((index = str.indexOf(matchStr)) != -1){
//                count++;
//                str = str.substring(index + matchStrLength);
//            }
            //second way:对方式一的改进
            while ((index = str.indexOf(matchStr,index)) != 0){
                count++;
                index += matchStrLength;
            }
        }else{
            return 0;
        }
        return count;
    }

    @Test
    public void test1(){
        String str1 = "ab";
        String str2 = "bbabcabcdkjkabkjdkab";
        System.out.println(getCount(str2,str1));

    }
}

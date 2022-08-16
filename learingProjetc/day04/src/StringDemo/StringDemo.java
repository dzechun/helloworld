package StringDemo;

import org.junit.Test;

public class StringDemo {
    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如”abcdefg“反转为"abfedcg"
    方式一：转换为char[]
     */

    public String reverse(String str,int startIndex,int endIndex){

        if(str != null){
            char[] arr = str.toCharArray();
            for(int x = startIndex,y = endIndex;x<y;x++,y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    @Test
    public void test1(){
        String str = "abcdefg";
        String str1 = reverse(str,2,5);
        System.out.println(str1);
    }

    //方式二：使用String的拼接
    public String reverse1(String str,int startIndex,int endIndex){

        if(str != null){
            //first part
            String reverseStr = str.substring(0, startIndex);
            //second part
            for(int i = endIndex;i >= startIndex;i--){
                reverseStr += str.charAt(i);
            }
            //third part
            reverseStr += str.substring(endIndex+1);
            return reverseStr;
        }

        return null;
    }

    @Test
    public void test2(){
        System.out.println(reverse1("abcdefg",2,5));
    }

    //方式三：使用StringBuffer\StringBuilder替换String
    public String reverse2(String str, int startIndex,int endIndex){

        if(str != null){
            StringBuilder builder = new StringBuilder(str.length());

            //first part
            builder.append(str.substring(0,startIndex));
            //second part
            for(int i = endIndex;i >= startIndex;i--){
                builder.append(str.charAt(i));
            }
            //third part
            builder.append(str.substring(endIndex+1));

            return str;
        }
        return null;
    }

}

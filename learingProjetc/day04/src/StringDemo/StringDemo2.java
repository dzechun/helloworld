package StringDemo;

import org.junit.Test;

public class StringDemo2 {

    /*
    获取两个字符串中最大相同字串。比如：
    str1 = "abcwertthelloyuiodef";str2 = "cvhellobnm"
    提示：将短的那个串进行长度依次递减的字串与较长的串比较
     */
//前提：两个字符串中只有一个最大相同字串
    public String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length())? str1:str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();
            for(int i = 0;i < length;i++){

                for(int x = 0,y = length - i;y <= length;x++,y++){
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testGetMaxSameString(){
        String str1 = "abcwertthelloyuiodef";
        String str2 = "cvhellobnmiodef";
        String maxSameString = getMaxSameString(str1,str2);
        System.out.println(maxSameString);
    }
}

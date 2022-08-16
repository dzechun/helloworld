package learning1;

public class ArrayTest2 {
    public static void main(String[] args){
       int[] array1, array2;
       array1 = new int[]{2,3,5,11,13,17,19};

       //显示array1的内容
        for(int i = 0;i < array1.length;i++){
            System.out.print(array1[i] + "\t");
        }

        //赋值array2变量等于array1
        array2 = array1;

        //修改array2中的偶数索引元素使其等于索引值（如array[0]=0,array[2]=2）
        for(int i = 0; i < array2.length; i++){
            if(i%2==0){
                array2[i] = i;
            }
        }
        //打印出array1
        for(int i = 0;i < array1.length;i++){
            System.out.println(array1[i]);
        }
    }
}

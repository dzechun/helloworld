package learning1;

public class ArrayTest {
    public static void main(String[] args){
        int[] num = new int[6];
        for(int i=0;i<num.length;i++){
            num[i] = (int) (Math.random()*30);
            if(i>0){
                boolean isEqual = true;
                while(isEqual){
                    for(int j = 1;j<=i;j++){
                        if(num[i] == num[j]){
                            num[j] = (int)(Math.random()*30);
                            break;
                        }else{
                            isEqual = false;
                        }
                    }
                    if(isEqual){break;}
                }
            }
        }
        for(int i = 0;i<num.length;i++) {
            System.out.println(num[i]);
        }

    }
}

package learning1;

import java.util.Scanner;

public class Utility {
    public static void readMenuSelection(){
        boolean isFlag = true;
        while(isFlag){
            Scanner input = new Scanner(System.in);
            char c = input.next().charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4'){

            }
        }
    }
}

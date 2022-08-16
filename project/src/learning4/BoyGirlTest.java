package learning4;

public class BoyGirlTest {
    public static void main(String[] args) {

        Boy boy = new Boy("nick",18);
        boy.shout();

        Girl girl = new Girl("lily",22);
        girl.marry(boy);

        Girl girl1 = new Girl("long",19);
        int compare = girl.compare(girl1);
        if(compare > 0){
            System.out.println();
        }

    }
}

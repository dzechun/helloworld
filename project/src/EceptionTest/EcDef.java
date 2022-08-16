package EceptionTest;

public class EcDef extends Exception{
    static final long serialVersionUID = -7034897745766932L;

    public EcDef(){

    }

    public EcDef(String msg){
        super(msg);
    }

}

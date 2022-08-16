import org.junit.Test;

import java.io.*;

public class FileReadWriterTest {


    @Test
    public void testFileReader() {
        File file = new File("hello.txt");
        FileReader fr = null;
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fr = new FileReader(file);
            int data = fr.read();
            while(data != -1){
                System.out.println((char)data);
                data = fr.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fr != null) {
                        fr.close();
                    }
                }catch (IOException e){
                e.printStackTrace();
                }
            }

        }

    @Test
    public void testReaderChar(){
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf))!=-1){
//                    for(int i = 0;i < len;i++){
//                        System.out.print(cbuf[i]);
//                    }
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testFileWriter(){
        File file = new File("hello1.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,false);
            fw.write("helloworld2");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw != null){
                try {
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileWriter2() throws IOException {
        File file = new File("hello1.txt");
        FileWriter fw = new FileWriter(file, false);
        fw.write("i hava a dream");
        fw.write("you need to have a dream");
        fw.close();
    }

    @Test
    public void testFileReaderWriter2() {

        FileReader fr = null;
        FileWriter fw = null;
        try{
            File infile = new File("hello.txt");
            File outfile = new File("hello1.txt");
            fr = new FileReader(infile);
            fw = new FileWriter(outfile);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

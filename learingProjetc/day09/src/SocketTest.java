import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketTest {

    @Test
    public void testClient(){
        Socket so = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            so = new Socket(inetAddress,8989);
            outputStream = so.getOutputStream();
            outputStream.write("客户端输入数据".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(so != null){
                    so.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testServer(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        try {
            ss = new ServerSocket(8989);
            accept = ss.accept();
            //中文可能会出现乱码
            is = accept.getInputStream();
//            byte[] bytes = new byte[20];
//            int len;
//            while((len = is.read(bytes))!= -1){
//                String str = new String(bytes,0,len);
//                System.out.println(str);
//            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while((len = is.read(bytes))!= -1){
                baos.write(bytes,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("收到来自："+accept.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(accept != null)
                    accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

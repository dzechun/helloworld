package preparedstatement;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedStatement {

    @Test
    public void getConnection() {
        //读取配置文件中的4个基本信息
        java.sql.PreparedStatement ps = null;
        Connection con = null;
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties pro = new Properties();
            pro.load(is);

            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String url = pro.getProperty("url");
            String driverClass = pro.getProperty("driverClass");

//        加载驱动
            Class.forName(driverClass);
//        获取数据库连接
            con = DriverManager.getConnection(url, user, password);
//        System.out.println(con);
//      预编译sql语句
            String sql = "insert into customer(customer_id,customer_name,salary,age) values (?,?,?,?);";
            ps = con.prepareStatement(sql);
//        填充占位符
            ps.setInt(1,1);
            ps.setString(2,"nick");
            ps.setString(3,"5000");
            ps.setInt(4,21);

//        执行操作
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
//            资源关闭
            try{
                if(ps != null)
                    ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                if(con != null)
                    con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
//
    }
}

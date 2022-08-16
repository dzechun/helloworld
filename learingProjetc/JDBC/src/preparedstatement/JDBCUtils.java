package preparedstatement;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    public static Connection getConnection(){

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

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//
        return con;
    }

    public static void closeConnection(Connection conn,Statement ps){

            try{
                if(conn != null)
                    conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(ps != null)
                    ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }

    }

    public static void closeConnection(Connection conn,Statement ps,ResultSet rs){

        try{
            if(conn != null)
                conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(ps != null)
                ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(rs != null)
                rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

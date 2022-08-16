package preparedstatement;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static preparedstatement.JDBCUtils.getConnection;

public class UpdateTest {

//    通用增删改操作
    public void update(String sql,Object ...args) throws SQLException {

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        for(int i = 0;i < args.length;i++){
             ps.setObject(i+1,args[i]);
        }
    }


    @Test
    public void test1() throws SQLException {
//        获取数据库连接
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtils.getConnection();
//        预编译sql语句，返回preparedStatement的实例
            String sql = "update customer set salary = ? where customer_id = ?";
            ps = con.prepareStatement(sql);
//        填充占位符
            ps.setString(1,"1000");
            ps.setInt(2,1);
//        执行
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //资源关闭
            JDBCUtils.closeConnection(con,ps);
        }

    }


}

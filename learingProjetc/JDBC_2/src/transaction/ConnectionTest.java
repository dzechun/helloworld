package transaction;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;

public class ConnectionTest {

    @Test
    public void test(){
        Connection con = JDBCUtils.getConnection();
        System.out.println(con);
    }
}

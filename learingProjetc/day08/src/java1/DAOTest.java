package java1;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1(){
        WebsitesDAO dao1 = new WebsitesDAO();
        dao1.add(new Websites());
        List<Websites> list = dao1.getForList(10);
    }
}

import jdk.jfr.StackTrace;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.transform.sax.SAXResult;
import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {

    @Test
    public void test1() throws DocumentException {

        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("XML/books.xml");

        System.out.println(document);

    }

    @Test
    public void test2() throws DocumentException {
//        1 读取books.xml文件
        SAXReader saxReader = new SAXReader();
//        2 通过Document对象获取根元素
        Document document = saxReader.read("XML/books.xml");
        Element rootElement = document.getRootElement();
//        3 通过根元素获取book标签对象
//        element()和elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
//        4 遍历，处理每个book标签转换为Book类
        for (Element book : books) {
//            asXML()把标签对象。转换未标签字符串
//            System.out.println(book.asXML());
            Element element = book.element("name");
//            获取标签中的文本内容
            String nameText = element.getText();
//            直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");

            String s = book.attributeValue("sn");

            new Book(s,nameText,Double.parseDouble(priceText),authorText);
        }
    }

}

package one;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestJsoupClass {
	public static void main(String[] args) throws IOException {
		File input = new File("C:\\Users\\Administrator\\Desktop\\wode.txt");
		Document doc = Jsoup.parse(input, "GBK", "");
		 System.out.println(doc);
		// Element title = doc.getElementById("cs_iday");
		// System.out.println(title);
		// System.out.println(doc.select(".inner-tab-panel.active").text());
		
//		Element image = doc.select("img").first();//获取一个索引的位置的图片
		Element image = doc.select("img").get(0);//根据索引获取指定位置的图片
		/*
		 * 获取标签内的属性的方法：select("标签名").attr("要获取的标签内的属性名");
		 * 根据标签选择器进行的操作！
		 * 注意：获取标签内的文本需要使用text()方法；
		 * 	         获取标签内属性的信息直接使用attr("要获取的标签内的属性名")；
		 */
//		String i=doc.select("div").get(2).attr("title");
//		String i1=doc.select("div").get(6).attr("title");
//		String price=doc.select("span").get(1).text();
//		String price2=doc.select("span").get(4).text();
//		System.out.println(i);
//		System.out.println(price);
//		System.out.println(i1);
//		System.out.println(price2);
		
		/*
		 * 获取标签内的属性的方法：select("标签名").attr("要获取的标签内的属性名");
		 * 根据类选择器进行的操作！
		 * 注意：获取标签内的文本需要使用text()方法；
		 * 	         获取标签内属性的信息直接使用attr("要获取的标签内的属性名")；
		 */
		System.out.println(doc.select(".product-item").attr("title"));
		System.out.println(doc.select("span.price").get(0).text());
	}
}

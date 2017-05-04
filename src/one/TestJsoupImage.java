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

public class TestJsoupImage {
	public static void main(String[] args) throws IOException {
		/*
		 * 去网络上截取图片的方法
		 */
		File input = new File("C:\\Users\\Administrator\\Desktop\\wode.txt");
		Document doc = Jsoup.parse(input, "UTF-8", "");
		// System.out.println(doc);
		// Element title = doc.getElementById("cs_iday");
		// System.out.println(title);
		// System.out.println(doc.select(".inner-tab-panel.active").text());
		
//		Element image = doc.select("img").first();//获取一个索引的位置的图片
		Element image = doc.select("img").get(0);//根据索引获取指定位置的图片
		String url = image.absUrl("src");
		System.out.println(url);
		// url = http://www.example.com/images/chicken.jpg
		URL url1 = new URL(url);
		URLConnection uc = url1.openConnection();
		InputStream is = uc.getInputStream();
		File file = new File("C:\\Users\\Administrator\\Desktop\\nihs.jpg");
		FileOutputStream out = new FileOutputStream(file);
		int i = 0;
		while ((i = is.read()) != -1) {
			out.write(i);
		}
		is.close();
	}
}

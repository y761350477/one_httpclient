package one;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoupReg {
	public static void main(String[] args) throws IOException {
		// 方法１: jsoup
		// String html = "<p class=\"info-detail-head-classify-subname\"><a
		// id=\"info_detail_head_classify_type\" href=\"\"
		// target=\"_blank\">财富</a></p>";
		File input = new File("C:\\Users\\Administrator\\Desktop\\wode.txt");
		Document doc = Jsoup.parse(input, "gbk", "");
//		Document doc = Jsoup.parse("<div class=\"product-item\" title=\"澳门3日自由行·往返含税特价机票【特卖】\">");
		String sdoc = doc.toString();
//		System.out.println(doc.getElementsByClass("product-item").attr("title"));
//		String sdoc=doc.select(".product-item").attr("title");
//		System.out.println(sdoc);
		// 方法2: regex
//		System.out.println(sdoc);
		Pattern r = Pattern.compile("class=\"product-item\".*?title=(.*?)>");
		Matcher m = r.matcher(sdoc);
		if (m.find()) {
			System.out.println(m.group(1));//获取正则表达式分组的方法
		}
	}
}

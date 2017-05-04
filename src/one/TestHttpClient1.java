package one;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestHttpClient1 {
	public static void main(String[] args) throws IOException {
		HttpClient hc = new HttpClient();
		HttpMethod method = new GetMethod("http://www.ctrip.com/");
//		HttpMethod method = new PostMethod("https://www.baidu.com/");
		hc.executeMethod(method);
		HttpMethodParams methodParams = method.getParams();
		methodParams.setContentCharset("UTF-8");
		String response = new String(method.getResponseBodyAsString().getBytes());
		System.out.println(response);
		Document doc = Jsoup.parse(response);// 解析HTML字符串返回一个Document实现
		// System.out.println("doc:"+doc);
		Element link = doc.select("p").first();// 查找第一个a元素
		System.out.println("查找第一个a元素  link:" + link);
		String text = doc.body().text(); // "An example link"//取得字符串中的文本
		System.out.println("text:" + text);
		String linkHref = link.attr("href"); // "http://example.com/"//取得链接地址
		System.out.println("linkHref:" + linkHref);
		String linkText = link.text(); // "example""//取得链接地址中的文本
		System.out.println("linkText:" + linkText);
		String linkOuterH = link.outerHtml();
		System.out.println("linkOuterH:" + linkOuterH);
		// "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"//取得链接内的html内容
		System.out.println("linkInnerH:" + linkInnerH);
	}
}

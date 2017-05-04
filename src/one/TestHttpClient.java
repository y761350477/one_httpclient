package one;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestHttpClient {
	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		// 设置代理服务器地址和端口
		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		 HttpMethod method = new GetMethod("http://www.baidu.com/");
		// 使用POST方法
//		HttpMethod method = new PostMethod("https://www.baidu.com/");
		// 设置编码
		HttpMethodParams methodParams = method.getParams();
		methodParams.setContentCharset("UTF-8");
		// 执行请求
		int state = client.executeMethod(method);
		if (state == 200) {
			// 打印服务器返回的状态
//			System.out.println(method.getStatusLine());
			// 打印返回的信息
			String str = method.getResponseBodyAsString();
			// System.out.println(str);
			Document doc = Jsoup.parse(str);// 解析HTML字符串返回一个Document实现
			System.out.println(doc);
			System.out.println("______________________");
			Element link = doc.select("a").first();// 查找第一个a元素
			String text = doc.body().text(); // "An example link"//取得字符串中的文本
			String linkHref = link.attr("href"); // "http://example.com/"//取得链接地址
			System.out.println(linkHref);
			String linkText = link.text(); // "example""//取得链接地址中的文本
			String linkOuterH = link.outerHtml();
			// "<a href="http://example.com"><b>example</b></a>"
			String linkInnerH = link.html(); // "<b>example</b>"//取得链接内的html内容
			System.out.println(text);
			// byte[] b=str.getBytes();
			// OutputStream os=new
			// FileOutputStream("C:\\Users\\Administrator\\Desktop\\wode.txt");
			// os.write(b);
			// if(os!=null){
			// os.close();
			// }
			// 释放连接
		}
		method.releaseConnection();
	}
}

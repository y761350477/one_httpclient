package one;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class SimpleHttpClient {
	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost("www.114best.com", 80, "http");
		HttpMethod method = getPostMethod(); // 使用 POST 方式提交数据
		// HttpMethod method = getGetMethod(); // 使用 GET 方式
		client.executeMethod(method); // 打印服务器返回的状态
		System.out.println(method.getStatusLine()); // 打印结果页面
		String response = new String(method.getResponseBodyAsString().getBytes("UTF-8"));
		// 打印返回的信息
		System.out.println(response);
		method.releaseConnection();
	}

	/**
	 * 使用 GET 方式提交数据
	 * 
	 * @return
	 */

	private static HttpMethod getGetMethod() {
		return new GetMethod("/dh/114.aspx?w=18638009287");
	}

	/**
	 * 使用 POST 方式提交数据
	 * 
	 * @return
	 */
	private static HttpMethod getPostMethod() {
		PostMethod post = new PostMethod("/dh/114.aspx");
		NameValuePair simcard = new NameValuePair("w", "1330227");
		post.setRequestBody(new NameValuePair[] { simcard });
		return post;
	}
}

package one;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestHttpClient2 {
	public static void main(String[] args) throws IOException {
        //相当于打开一个浏览器
HttpClient hp = new HttpClient();
        //访问输入的地址
GetMethod get = new GetMethod("https://www.baidu.com/");
        //状态码，后期貌似很重要，可以提示这个网页打不打得开
int status = hp.executeMethod(get);
if(status!=HttpStatus.SC_OK){System.out.println("error");}

        //获取该页的源代码
String html = get.getResponseBodyAsString();
        //解决字符串中文乱码问题
html = new String(html.getBytes("ISO-8859-1"),"utf-8");
System.out.println(html);
		}
	}

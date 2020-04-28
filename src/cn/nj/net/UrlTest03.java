package cn.nj.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 模拟网络爬虫+模拟游览器响应（遇到网页拒绝抓取时使用）
 * 网络爬虫步骤：1、获得url；2、下载资源；3、分析数据；4、处理数据
 * 通过使用HttpURLConnection子类和url.openConnection获得（当通信协议为http时）
 * @author edz
 */
public class UrlTest03 {
    public static void main(String[] args) throws IOException {
        URL url=new URL("Https://www.dianping.com");
        //下载资源
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        //请求协议由get和post，其中get不安全，量小，post量大安全，在请求体中储存
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent"," Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36");
        InputStream is= connection.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
        //操作
        String s=null;
        while((s=bufferedReader.readLine())!=null){
            System.out.println(s);
        }
        bufferedReader.close();






//        InputStream inputStream = url.openStream();
//        OutputStream outputStream=new FileOutputStream("t.txt");
//        int length=-1;
//        byte [] flush =new byte[1024];
//        while((length=inputStream.read(flush))!=-1){
//            outputStream.write(flush,0,length);
//
//        }
//            outputStream.flush();
//
//            outputStream.close();
//            inputStream.close();




    }

}

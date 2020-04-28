package cn.nj.net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 模拟网络爬虫
 * @author edz
 */
public class UrlTest02 {
    public static void main(String[] args) throws IOException {
        //获取URL(如果访问没有被禁止)
        URL url=new URL("Https://www.jd.com");
        //下载资源
        InputStream is= url.openStream();
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

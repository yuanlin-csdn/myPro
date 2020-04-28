package cn.nj.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL：由四部分组成：协议、存放资源的主机域名、端口、资源文件名
 * 网络三大基石：html、http、url
 * 举例：http://www.baidu.com:80/index.html?uname=sxt&age=18#a;
 * 解释：http指-->tcp协议；3w指-->域名；80指-->端口；index.html指-->资源文件名；  ？后面指-->用户参数；#指-->锚点a（同一页面跳转使用）
 * @author edz
 */
public class UrlTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("http://www.baidu.com:80/index.html?uname=陈平安&age=25#a");
        System.out.println("协议名称:"+url.getProtocol());
        System.out.println("域名:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        //完整资源名
        System.out.println("请求资源1:"+url.getFile());
        //资源名URI
        System.out.println("请求资源2:"+url.getPath());

        //锚点
        System.out.println("锚点:"+url.getRef());
        //用户参数
        System.out.println("用户参数:"+url.getQuery());

    }

}

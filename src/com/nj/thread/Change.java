package com.nj.thread;

/**
 * 进制转换
 */

public class Change {
    /*转为16进制*/
    static  void char_16(int n){
        if (n>=16 ){
            char_16(n/16);
        }
        if (n%16<10){
            System.out.print(n%16);
        }else{
            System.out.print((char)(n%16+55));
        }

    }
    /*8进制*/
    static  void char_8(int n){
//        if (n>=8 ){
//            char_8(n/8);
//        }
//        System.out.print(n%8);
        if (n>=8){
            char_8(n/8);
            System.out.print(n%8);
        }else{
            System.out.print(n);
        }
    }
    /*2进制*/
    static void char_2(int n){
        if (n>=2){
            char_2(n/2);
        }
        System.out.print(n%2);
    }


    public static void main(String[] args) {
        int a=27;
        int b=25 ;
        int c=25 ;
        System.out.print("十进制"+a+"--》16进制：");
        char_16(a);
        System.out.println();
        System.out.print("十进制"+b+"--》8进制：");
        char_8(b);
        System.out.println();
        System.out.print("十进制"+c+"--》2进制：");
        char_2(c);


    }



}

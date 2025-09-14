package com.example.myworld;


import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/26
 * Description:
 */

class Test3{
    public static void main(String args[]) {
//        String aa = null;
//        String bb = (String)aa ;
        Test2 aa =null;
        Test bb = (Test)aa;
//        println("llll---->"+bb);
        System.out.println("llll---->"+bb);
    }

}
class Test {
    interface Listener {
        String result = "Hello World";
        void doSth();
    }
}

class Test2 extends Test{

}

package com.example.worldlab.thought.commonJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 * https://chat.deepseek.com/a/chat/s/a4aed9e0-6509-4f88-8e65-11d59a85aa03
 */
class Test_No_Reflect_O {


    public static void main(String[] args) throws IllegalAccessException,
            NoSuchFieldException, NoSuchMethodException,
            InvocationTargetException, ClassNotFoundException,
            InstantiationException {

        // 1. 通过类名.class
        Class<String> stringClass = String.class;

        // 2. 通过对象.getClass()
        String str = "hello";
        Class<?> strClass = str.getClass();

        // 3. 通过Class.forName()
        Class<?> clazz3 = Class.forName("java.lang.String");


        // 使用无参构造器
        Class<?> userClass = Class.forName("com.example.User");
        Object user1 = userClass.newInstance(); // 已过时，推荐用下面的方式
        Object user2 = userClass.getDeclaredConstructor().newInstance();

        // 使用有参构造器
        Constructor<?> constructor = userClass.getDeclaredConstructor(String.class, int.class);
        Object user3 = constructor.newInstance("张三", 25);



        // 访问公共字段
        User user = new User("李四", 30);
        Class<?> clazz = user.getClass();

        Field ageField = clazz.getField("age");
        System.out.println("年龄: " + ageField.get(user)); // 输出: 30

        // 修改公共字段
        ageField.set(user, 35);
        System.out.println("修改后年龄: " + user.age); // 输出: 35

        // 访问私有字段
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true); // 设置可访问
        System.out.println("姓名: " + nameField.get(user)); // 输出: 李四

        // 修改私有字段
        nameField.set(user, "王五");
        System.out.println("修改后姓名: " + nameField.get(user)); // 输出: 王五




        // 调用公共方法
        Calculator calc = new Calculator();
        Class<?> clazz2 = calc.getClass();

        Method addMethod = clazz2.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(calc, 10, 20);
        System.out.println("加法结果: " + result); // 输出: 30

        // 调用私有方法
        Method multiplyMethod = clazz2.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);
        Object multiplyResult = multiplyMethod.invoke(calc, 5, 6);
        System.out.println("乘法结果: " + multiplyResult); // 输出: 30

        // 调用静态方法
        Method staticMethod = clazz2.getMethod("staticMethod");
        staticMethod.invoke(null); // 静态方法传入null作为对象

    }

    public static class User {
        private String name;
        public int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        private int multiply(int a, int b) {
            return a * b;
        }

        public static void staticMethod() {
            System.out.println("静态方法被调用");
        }
    }


}

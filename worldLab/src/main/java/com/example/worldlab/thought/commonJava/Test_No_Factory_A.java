package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 */
class Test_No_Factory_A {

    public static void main(String[] args) {

        ShapeFactory.getShape("Circle").draw();
    }

    public interface Shape {
        void draw();
    }

    public static class Circle implements Shape {
        public void draw() {

        }
    }

    public static class Rectangle implements Shape {

        public void draw() {

        }
    }

    public static class ShapeFactory {
        public static Shape getShape(String type) {
            if (type.equals("Circle")) {
                return new Circle();
            } else if (type.equals("Rectangle")) {
                return new Rectangle();
            }
            return new Circle();

        }

    }


}

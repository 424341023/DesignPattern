package com.rongguang.principle.liskov;

/**
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月20日 22:12:52
 * @packageName com.rongguang.principle.liskov
 * @className Liskov
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("10 - 5 = " + a.func1(10, 5));
        System.out.println("1 - 8 = " + a.func1(1, 8));

        System.out.println("----------------------------------");
        B b = new B();
        System.out.println("10 - 5 = " + b.func1(10, 5)); // 本意是求出10-5
        System.out.println("1 - 8 = " + b.func1(1, 8));
        System.out.println("1 + 8 + 10 = " + b.func2(11, 3));
    }


}

// A类
class A {
    // 返回两个数的差
    public int func1(int num1, int num2){
        return num1 - num2;
    }
}

// B类继承了A
// 增加了一个新功能：完成两个数相加，然后和10求和
class B extends A {

    // 这里重写了A类的方法，并且改变返回值，可能是无意识的
    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a, b) + 10;
    }
}
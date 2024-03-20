package com.rongguang.principle.inversion.improve;

/**
 * 依赖关系传递的三种方式
 *
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月20日 21:29:20
 * @packageName com.rongguang.principle.inversion.improve
 * @className DependencyPass
 */
public class DependencyPass {
    public static void main(String[] args) {

        // 两个接口的实现类，用实现类来实例化对象
        // 方式1: 通过接口传递实现依赖
        ChandHong1 chandHong1 = new ChandHong1();
        OpenAndClose1 openAndClose = new OpenAndClose1();
        openAndClose.open(chandHong1);

        // 方式2: 通过构造函数传递实现依赖
        ChandHong2 chandHong2 = new ChandHong2();
        OpenAndClose2 openAndClose2 = new OpenAndClose2(chandHong2);
        openAndClose2.open();

        // 方式3: 通过setter方法传递实现依赖
        ChandHong3 chandHong3 = new ChandHong3();
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setItv3(chandHong3);
        openAndClose3.open();


    }
}

// 方式1: 通过接口传递实现依赖
// 开关的接口
interface IOpenAndClose1 {
    public void open(ITV1 itv1); // 抽象方法，接收接口
}

// 电视的接口
interface ITV1 {
    public void play();
}

// 实现开关接口
class OpenAndClose1 implements IOpenAndClose1 {
    @Override
    public void open(ITV1 itv1) {
        itv1.play();
    }
}

// 实现电视接口
class ChandHong1 implements ITV1 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

// 方式2: 通过构造方法进行依赖传递
interface IOpenAndClose2 {
    public void open(); // 抽象方法，接收接口
}

interface ITV2 {
    public void play();
}

class ChandHong2 implements ITV2 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class OpenAndClose2 implements IOpenAndClose2 {
    // 将接口作为成员变量
    public ITV2 itv2;

    public OpenAndClose2(ITV2 itv2) {
        this.itv2 = itv2;
    }

    @Override
    public void open() {
        this.itv2.play();
    }
}

// 方式3: 通过setter方法进行依赖传递
interface IOpenAndClose3 {
    public void open(); // 抽象方法，接收接口

    public void setItv3(ITV3 itv3); // 抽象方法，接收接口
}

interface ITV3 {
    public void play();
}

class OpenAndClose3 implements IOpenAndClose3 {
    // 将接口作为成员变量
    private ITV3 itv3;

    public void open() {
        this.itv3.play();
    }

    public void setItv3(ITV3 itv3) {
        this.itv3 = itv3;
    }
}

class ChandHong3 implements ITV3 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}
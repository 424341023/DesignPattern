package com.rongguang.uml.dependence;

/**
 * 依赖关系
 * 只要是在类中用到了对方，那么他们之间就存在依赖关系。
 * 如果没有对方，连编译都通过不了
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月21日 21:19:49
 * @packageName com.rongguang.uml.dependence
 * @className PersonServiceBean
 */
public class PersonServiceBean {
    // 作为成员变量
    private PersonDao personDao;

    // 作为方法接收的参数类型
    public void save(Person person){
    }

    // 作为方法的返回类型
    public IDCard getIDCard(Integer personId){
        return null;
    }

    public void modify(){
        // 方法中使用到
        Department department = new Department();
    }

}

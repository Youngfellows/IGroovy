package com.pandora.groovy.obj

/**
 * Person类的管理器
 */
class PersonManager {
    //通过静态注入的createPerson方法，创建Person对象
    static Person createPerson(String name, int age) {
        return Person.createPerson(name,age)
    }
}

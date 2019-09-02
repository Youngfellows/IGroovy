package com.pandora.groovy.obj

/**
 * 应用程序的入口
 */
class Entry {
    public static void main(String[] args) {
        println "应用程序正在启动..."
        ApplicationManager.init()
        println "应用程序初始化完成..."

        //通过动态注如的方法创建对象
        def person = PersonManager.createPerson('xiaoming', 16)
        println "the person name is ${person.name},and age is ${person.age}"
    }
}

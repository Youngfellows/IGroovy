package com.pandora.groovy.obj

/**
 * 模拟一个应用程序的管理器
 */
class ApplicationManager {
    static void init() {
        //ExpandoMetaClass声明之后动态注册的方法或属性可以在第三方类引用到
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加静态方法
        Person.metaClass.static.createPerson = { String name, int age ->
            //为类Person创建静态方法createPerson，创建Person对象
            new Person(name: name, age: age)
        }
    }
}

package com.pandora.groovy.clouser

/**
 * 三、闭包的三个重要变量：this,owner,delegate
 * 总结: 1.大多数情况下，this，owner,delegate一致
 *       2.只有在闭包中的闭包，this,owner,deletate不一致，可以修改deletate的指向。委托策略
 */
println "======================== 闭包中的 this,owner,delegate ===================================="
def scriptClosure = {
    println "scriptClosure this: " + this //代表闭包定义处的类
    println "scriptClosure owner: " + owner //代表闭包定义处的类或者对象
    println "scriptClosure delegate: " + delegate //代表任意对象,默认与owner一致
}
//调用闭包
scriptClosure.call()


println "======================== 内部类 闭包中的 this,owner,delegate ===================================="
println "======================== 内部类 方法的 this,owner,delegate   ===================================="
//定义一个内部类
class Person {
    //静态闭包
    def static classClosure = {
        println "classClosure this: " + this
        println "classClosure owner: " + owner
        println "classClosure delegate: " + delegate
    }

    //非静态闭包
    def classClosure2 = {
        println "classClosure2 this: " + this
        println "classClosure2 owner: " + owner
        println "classClosure2 delegate: " + delegate
    }

    //静态方法
    def static say() {
        def methodClosure = {
            println "methodClosure this: " + this
            println "methodClosure owner: " + owner
            println "methodClosure delegate: " + delegate
        }
        //调用闭包
        methodClosure.call()
    }

    //非静态方法
    def drink() {
        def methodClosure2 = {
            println "methodClosure2 this: " + this
            println "methodClosure2 owner: " + owner
            println "methodClosure2 delegate: " + delegate
        }
        //调用闭包
        methodClosure2.call()
    }
}
//调用静态方法,静态闭包的this,owner,delegate指向的是同一个类Person
Person.classClosure.call()
Person.say()

//调用非静态方法,非静闭包中的this,owner,delegate指向的是同一个对象
def person = new Person()
person.classClosure2.call()
person.drink()


println "======================== 闭包的委托策略   ===================================="
/**
 * 四、闭包的委托策略
 */
class Teacher {
    String name
}

class Student {
    String name
    //定义闭包
    def pretty = {"My name is ${name}"}

    String toString() {
        pretty.call()
    }
}

def stu = new Student(name: 'xiaoming')
def teacher = new Teacher(name: 'ligang')
println stu.toString()

//委托策略
stu.pretty.delegate = teacher
//stu.pretty.resolveStrategy = Closure.OWNER_ONLY
//stu.pretty.resolveStrategy = Closure.OWNER_FIRST
//stu.pretty.resolveStrategy = Closure.DELEGATE_ONLY
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toString()
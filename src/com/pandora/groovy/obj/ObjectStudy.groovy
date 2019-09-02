package com.pandora.groovy.obj;

/**
 * 2.无论你是直接.调用，还是get/set调用，最终都是调用get/set
 */
def person = new Person(name: 'xiaoming', age: 18)
println "the name is ${person.name}, the age is ${person.getAge()}"
person.eat()
person.drink()
person.play()
person.walk()
person.driving()

/***
 * 3.groovy中的元编程
 */
println person.cry()//Person没有定义cry()方法

//为类动态的添加一个属性
Person.metaClass.sex = 'male'//添加属性sex
def person1 = new Person(name: 'yangguo', age: 26)
println person1.sex
//修改属性值
person1.sex = 'female'
println "the new sex is ${person1.sex}"

//为类动态的添加一个方法
Person.metaClass.sexUpperCase = { ->
    sex.toUpperCase()
}
def person2 = new Person(name: 'lili', age: 18)
person2.sex = 'female'
println person2.sexUpperCase()


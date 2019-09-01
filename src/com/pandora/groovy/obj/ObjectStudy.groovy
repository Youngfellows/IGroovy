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



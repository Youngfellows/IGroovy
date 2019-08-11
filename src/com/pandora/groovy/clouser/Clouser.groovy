package com.pandora.groovy.clouser

/**
 * 1.闭包的概念，一段代码块
 */

//定义闭包
def clouser = {
    println 'hello groovy!'
}

//调用闭包
clouser.call()
clouser()//同方法差不多


/***
 *
 * 2.闭包的参数
 * 通过箭头号区分参数和闭包体
 */
def clouser2 = {
        //参数是String name
    String name ->
        println "hello ${name}"
}

//调用带参数的闭包
clouser2('groovy')
def name = 'groovy'
clouser.call(name)

//多个参数,逗号隔开
def clouser3 = {
        //参数是String name
    String name1, int age ->
        println "hello ${name1},my age is ${age}"
}

//调用带参数的闭包
def name1 = 'groovy'
clouser3(name1, 4)
clouser3.call(name1, 4)

//默认参数
def clouser4 = {
    println "Hello ${it}"
}
clouser4('groovy')


/***
 * 2.闭包的返回值
 * 没有return 闭包返回null
 */
def result = clouser4('groovy')
println result

def clourser5 = {
    String name2 ->
        return "Hello ${name2}"
}

result = clourser5('groovy')
println result



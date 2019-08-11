package com.pandora.groovy.variable

import org.codehaus.groovy.runtime.StringGroovyMethods

//字符串定义
def name = 'a single string'
println name.class

//特殊字符，单引号
def name1 = 'a single \'a\' string'
println name1

//三引号字符串
def thupleName = '''three signle string'''
println thupleName.class
println thupleName

//区别，三引号有格式。单引号无格式，需要使用转义字符
def thupleName1 = '''\
line one
line two
line three
'''
println thupleName1


//双引号定义字符串,可扩展字符串
def doubleName = "this a common string"
println doubleName.class

//双引号定义字符串,可扩展字符串，引用变量
def name2 = "Qndroid"
//扩展表达式
def sayHello = "Hello: ${name2}"
println sayHello
println sayHello.class

//扩展表达式,可以扩展是任意表达式.GString类型
def sum = "the sum of 2 and 3 equals ${2 + 3}"
println sum

//不同类型的String和GString 之间转换
def result = echo(sum)//参数是GString
println result
println result.class

//定义方法，参数是String类型，返回是String
String echo(String message) {
    return message
}

/*================StringGroovyMethods字符串的方法=================*/
def str = "groovy"
//字符串扩充
println str.center(8, 'a')//以‘a’填充
println str.center(8)//以空格填充

//在左边填充
println str.padLeft(8, 'a')
println str.padLeft(8)

//在右边填充
println str.padRight(8, 'a')
println str.padRight(8)

//字符串比较
def str2 = 'groovy Hello'
//使用操作符进行比较
println str > str2
println str.compareTo(str2)

//获取字符串中字符的索引
println str.getAt(0)
println str[0]
println str[0..1]//输出结果是gr，范围

//字符串减法
println str.minus(str2)
println str - str2

//反向字符串
println str.reverse()

//大写首字母字符串
println str.capitalize()

//是否是数字类型
println str.isNumber()

//转换为int类型
str = 123
str.toInteger()
println str.class

str = 123.45
str.toDouble()
println str.class



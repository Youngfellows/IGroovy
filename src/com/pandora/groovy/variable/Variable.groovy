package com.pandora.groovy.variable

//强类型定义变量
int x = 10
//包装类型
println x.class

//强类型定义变量
double  y = 3.14
//包装类型,对象类型
println y.class


//弱类型定义变量
def x_1 = 11
def y_1 = 3.14159
def name = "qandroid"
println x_1.class
println y_1.class
println name.class

//改变变量类型
x_1 = "test"
println x_1.class


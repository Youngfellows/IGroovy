package com.pandora.groovy.ifelse
//逻辑控制,可以放入任何类型

//1.switch 语句
def x = 1.23
def result;
switch (x) {
//switch (x.class) {//类型
    case 'foo':
        result = 'found foo'
        break;
    case 'bar':
        result = 'bar'
        break;
    case [1.23, 4, 5, 6, 'inlist']:
        result = 'inlist'
        //ArrayList 列表
        break;
    case [12..30]:
        //范围12-30
        result = 'range'
        break;
    case Integer://类型
        result = 'interger'
        break;
    case BigDecimal:
        result = 'big decimal'
        break;
    default:
        result = 'default'
}
println result

//2.for循环
//对范围的for循环
def sum = 0
for (i in 0..9) {
    //范围从0到9
    sum += i
}
println "range sum = ${sum}"
sum = 0;

//对list的循环
for (i in [1, 2, 3, 4, 5, 6, 7, 8, 10]) {
    //取list的每一个元素
    sum += i
}
println "list sum = ${sum}"
sum = 0

//对map循环
for (i in ['lili': 1, 'luck': 2, 'xiaoming': 3]) {
    //取map的每一个元素
    sum += i.value
    //i.key
}
println "map sum = ${sum}"
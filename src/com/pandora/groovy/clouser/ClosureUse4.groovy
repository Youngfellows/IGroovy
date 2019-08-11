package com.pandora.groovy.clouser

/**
 * 二、Groovy的数据结构
 */

/***
 * 1.范围的定义,初始化
 */
def range = 1..10

//获取范围的元素
println "第3个元素${range[2]}"
println "${range.toListString()},是否包含元素7:${range.contains(7)},是否包含元素13:${range.contains(13)}"
println "range范围元素从${range.from}到${range.to}"


//范围的遍历,使用each和闭包遍历
def result = range.each {
    println it
}
println "遍历出的列表是${result.toListString()}"

//使用for遍历
for (num in range) {
    println num
}

//范围在switch case中使用
//定义方法
def getGrade(Number number) {
    def result
    switch (number) {
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<80:
            result = '良好'
            break
        case 80..100:
            result = '优秀'
            break
    }
    return result
}

//调用方法
def num = 45
def result2 = getGrade(num)
println "${num}是${result2}"

num = 64
result2 = getGrade(num)
println "${num}是${result2}"

num = 72
result2 = getGrade(num)
println "${num}是${result2}"

num = 94
result2 = getGrade(num)
println "${num}是${result2}"
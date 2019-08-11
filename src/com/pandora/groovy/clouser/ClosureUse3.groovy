package com.pandora.groovy.clouser

/**
 * 二、Groovy的数据结构
 */

/***
 * 1.map映射定义,初始化
 */
//java中定义map
//def map = new HashMap()

//groovy中定义map并初始化key-value
def colors = ['red': 'ff0000',
              green: '00ff00',
              blue : '0000ff']

println "colors类型${colors.getClass()}"

//索引map元素
println "greed -->> ${colors['green']}"
println "red -->> ${colors.red}"
println "colors 集合:${colors.toMapString()}"

/**
 * 2.map的添加
 */
//添加map元素
colors.yellow = 'ffff00'
colors.leftShift([grey: '00bbff'])
println "添加元素后 colors 集合:${colors.toMapString()}"
//添加不同类型的key-value
colors.comples = [a: 1, b: 2, c: 'apple']
println "添加元素后 colors 集合:${colors.toMapString()}"


/**
 * 3.map的删除,使用remove,同java一样
 */
colors.remove('grey')//要删除元素的key
colors.remove('green')
println "删除元素后 00bbff 集合:${colors.toMapString()}"

/***
 * 二、Map的操作
 */
//定义students 的集合,由5个元素,每一个元素又是一个map集合
def students = [1: [number: '0001', name: 'lili', score: 37, sex: 'female'],
                2: [number: '0002', name: 'jenny', score: 65, sex: 'female'],
                3: [number: '0003', name: 'xiaohai', score: 45, sex: 'male'],
                4: [number: '0004', name: 'dandan', score: 93, sex: 'female'],
                5: [number: '0005', name: 'mingming', score: 55, sex: 'male']]

/**
 * 1.map的遍历
 */
//使用each遍历出每一个entry
students.each {
    def student ->
        println "key是${student.key},value是${student.value}"
}

//使用each遍历出每一个entry,带索引index
students.eachWithIndex {
        //Map.Entry<Integer, LinkedHashMap<String, Serializable>> entry, int i ->
    def student, int index ->
        println "index索引是${index},key是${student.key},value是${student.value}"
}

//直接遍历kye-value
students.each {
    key, value ->
        println "key是${key},value是${value}"
}

//直接遍历kye-value,带索引index
students.eachWithIndex {
    key, value, index ->
        println "index索引是${index},key是${key},value是${value}"
}

/**
 * 2.map的查找操作
 */
def entry = students.find {
    def student ->
        //查找出第一个成绩大于60的元素
        return student.value.score >= 60
}
println "第一个成绩大于60的学生是:${entry}"

def entrys = students.findAll {
    def student ->
        //查找成绩大于60的全部元素,并返回
        return student.value.score >= 60
}
println "成绩大于60的元素是${entrys}"

//查找满足某一条件的元素个数
def count = students.count {
    def student ->
        return student.value.score >= 60 && student.value.sex == 'male'
}
println "成绩大于60分的男生个数是:${count}"

//查找满足某一条件的元素,保存到一个集合,并返回
def names = students.findAll {
    def student ->
        //返回成绩大于60分的元素的列表
        return student.value.score >= 60
}.collect {
    //返回成绩大于60分的元素的列表的名字
    return it.value.name
}
println "成绩大于60分的元素的列表的名字${names.toListString()}"


/**
 * 3.map的分组
 */
//根据成绩是否及格来分组
def group = students.groupBy {
    def student ->
        return student.value.score >= 60 ? '及格' : '不及格'
}
println "及格的人数分组是: ${group.toMapString()}"


/**
 * 4.map的排序
 */
//返回排序后的map
def sort = students.sort {
    def student1, student2 ->
        Number score1 = student1.value.score
        Number score2 = student2.value.score
        return score1 == score2 ? 0 : score1 < score2 ? 1 : -1
}

println "成绩排序后的结果是:${sort.toMapString()}"
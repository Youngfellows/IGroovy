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

/**
 * 1.map的遍历
 */

/**
 * 2.map的查找操作
 */

/**
 * 3.map的分组
 */

/**
 * 4.map的排序
 */
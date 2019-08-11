package com.pandora.groovy.clouser

/**
 * 一、Groovy的数据结构
 */

/***
 * 1.列表定义,初始化
 */
//java的列表定义信息
def list = new ArrayList()
println "list类型: ${list.class}"

//groovy列表定义
def list1 = [1, 2, 3, 4, 5]
println "列表大小:${list1.size()},list1类型: ${list1.class}"


//2.数组的定义,使用as指明是int类型数组，或者强类型指定为数组
def array = [1, 2, 3, 4, 5, 6, 7] as int[]
int[] array2 = [1, 2, 3, 4, 5, 6, 7, 8]
println "数组的大小: ${array.size()},类型: ${array.class}"
println "数组的大小: ${array2.length},类型: ${array2.class}"

/***
 * 二、列表的添加
 */
def list2 = [1, 2, 3, 4, 5, 7]
println "添加列表前:${list2.toListString()}"

list2.add(6)//在列表末尾添加
println "添加列表后:${list2.toListString()}"

list2.leftShift(8)
println "添加列表后:${list2.toListString()}"

list2 << 9
println "添加列表后:${list2.toListString()}"

def plusList = list2 + 10
println "添加列表后:${plusList.toListString()}"

/***
 * 三、列表的删除
 */
def list3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
println "列表删除前: ${list3.toListString()}"
list3.remove(7)//删除索引位置7的元素
println "删除索引位置7后,列表为: ${list3.toListString()}"

list3.remove((Object) 9)
println "删除元素9后,列表为: ${list3.toListString()}"

list3.removeAt(4)
println "删除索引位置4后,列表为: ${list3.toListString()}"

list3.removeElement(10)
println "删除元素10后,列表为: ${list3.toListString()}"

//按条件删除,删除全部偶数后
list3.removeAll { return it % 2 == 0 }
println "删除偶数元素后,列表为: ${list3.toListString()}"

//删除元素1,11
println "删除元素1和11后:${list3 - [1, 11]}"


/**
 * 四、列表的排序
 */
def sortList = [6, -3, 9, 2, 0, -7, 1, 5, 4, -8]
println "列表排序前:${sortList.toListString()}"
//java中的排序
Collections.sort(sortList)//默认由小到大排序

//自定义排序规则
Comparator mc = {
    a, b ->
        //按绝对值由小到大排序
        a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
Collections.sort(sortList, mc)
println "java中的排序后:${sortList.toListString()}"

def sortList2 = [6, -3, 9, 2, 0, -7, 1, 5, 4, -8]
println "列表排序前:${sortList2.toListString()}"
sortList2.sort()//默认排序方式
println "列表排序后:${sortList2.toListString()}"

//按照绝对值由大到小排序
sortList2.sort {
    int a, b ->
        //绝对值由大到小排序
        a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}
println "绝对值由大到小,列表排序后:${sortList2.toListString()}"

//自定义排序规则
def sortStringList = ['abc', 'z', 'hello', 'groovy', 'android', 'java']
sortStringList.sort {
    String s ->
        return s.size()
}
println "按照字符大小排序后:${sortStringList.toListString()}"

/**
 * 五、列表的查找
 */
def findList = [-3, 9, 6, 2, -7, 8, 1, -5, 4]
//查找符合条件的第一个元素
def result = findList.find {
    //使用默认的参数，遍历元素，如果是偶数，则返回该偶数
    return it % 2 == 0
}
println "在列表中:${findList.toListString()},查找到第一个偶数:${result}"

//在列表中查找符合条件的全部元素,保存到列表中,并返回
def result2 = findList.findAll {
    int e ->
        //查找出列表的全部基数
        e % 2 != 0
}
println "在列表中:${findList.toListString()},查找到奇数:${result2.toListString()}"

//查找列表中元素是否满足某一条件
def result3 = findList.any {
    //查找列表中是否包含偶数
    return it % 2 == 0
}
println "在列表:${findList.toListString()},是否包含偶数:${result3}"

//查找列表元素是否全部满足某个条件
def result4 = findList.every {
    int x ->
        //查找列表元素是否全部是偶数
        return x % 2 == 0
}
println "在列表:${findList.toListString()},是否全部是偶数:${result4}"

//查找符合条件的最大元素/最小元素
def min = findList.min()//默认条件
def max = findList.max()//默认条件
println "列表${findList.toListString()},中最小元素:${min},最大元素:${max}"

//自定义条件,大小规则
min = findList.min {
    //绝对值最小的元素
    return Math.abs(it)
}
max = findList.max {
    //绝对值最大
    return Math.abs(it)
}
println "列表${findList.toListString()},绝对值最小元素:${min},绝对值最大元素:${max}"


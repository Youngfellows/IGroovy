package com.pandora.groovy.clouser

/***
 * 一、与普通变量的结合使用
 */
/***
 * 1.求阶乘
 */
int num = 5;
int x = fab(num)
println "${num}的阶乘: ${num}!=${x}"

//fab方法用来求变量number的阶乘
int fab(int number) {
    int result = 1;
    //闭包做为方法的参数
    1.upto(number, { num -> result *= num })
    return result
}

//fab2求阶乘
int fab2(int number) {
    int result = 1
    //闭包是方法的参数，放到方法外
    number.downto(1) {
        num -> result *= num
    }
    return result
}

x = fab2(num)
println "${num}的阶乘: ${num}!=${x}"

/****
 * 2.求1到100的和
 */
int cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result
}

x = cal(101)
println "1到100的和： sum = ${x}"


/****
 * 二、字符串与闭包的结合使用
 */
//定义字符串
String str = 'the 2 and 3 is 5'
//1.each的遍历
println str.each {
    //遍历出来的每一个元素作为参数，箭头后的是方法体
    //String temp -> print temp;
}

//2.find用来查找符合条件的第一个元素
def result = str.find {
        //闭包作为函数参数的最后一个，可以放到方法的外面
        //遍历出的元素,作为参数s,判断每一个元素是否是数字
    String s -> s.isNumber()
}

println "使用find遍历出的第一个数字是: ${result}"

//3.查找字符串中符合条件的所有元素，并返回到一个list集合中
def list = str.findAll {
        //闭包作为函数参数的最后一个，可以放到方法的外面
        //遍历出的元素,作为参数s,判断每一个元素是否是数字,如果是数字就加入到list结合中，然后返回list集合
    String s -> s.isNumber()
}

//打印返回的数字的list集合
println list.toListString()

//3.判断字符串是否满足某种条件
boolean result1 = str.any {
        //只要字符串中包含数字，就返回true,否则返回flse
    String s -> s.isNumber()
}
println "字符串: ${str},是否包含数字: ${result1}"

//4.判断字符串中每一项是否满足某个条件
def result2 = str.every {
        //只有字符串中每一项都是数字，才返回true,否则返回false
    String s -> s.isNumber()
}

println "字符串: ${str},每一项是否都是数字: ${result2}"

//5.将字符串中的每一个元素，应用于闭包，闭包产生一个新的结果返回
list = str.collect {
    //使用默认参数
    //将当前字符转换为大写
    it.toUpperCase()
}
println "${str}转换为大字符list结果： ${list.toListString()}"
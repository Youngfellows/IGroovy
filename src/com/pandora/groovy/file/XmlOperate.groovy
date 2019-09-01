package com.pandora.gtroovy.file

import groovy.util.slurpersupport.GPathResult
import groovy.xml.MarkupBuilder

//定义xml字符串
final String xml = '''
  <response version-api="2.0">
    <value>
      <books id="1" classification="android">
        <book available="20" id="1">
          <title>疯狂Android讲义</title>
          <author id="1">李刚</author>
        </book>
        <book available="14" id="2">
          <title>第一行代码</title>
          <author id="2">郭林</author>
        </book>
        <book available="13" id="3">
          <title>Android开发艺术探索</title>
          <author id="3">任玉刚</author>
        </book>
        <book available="5" id="4">
          <title>Android源码设计模式</title>
          <author id="4">何红辉</author>
        </book>
      </books>
      <books id="2" classification="web">
        <book available="10" id="1">
          <title>Vue从入门到精通</title>
          <author id="4">李刚</author>
        </book>
      </books>
    </value>
  </response>
 '''

/**
 * 一、解析XML格式数据
 */
//开始解析xml数据
def xmlSlurper = new XmlSlurper()
//解析出的是response节点
def response = xmlSlurper.parseText(xml)

//获取节点数据
//第一个books下第一个book节点
println response.value.books[0].book[0].title.text()
println response.value.books[0].book[0].author.text()

//获取节点属性
println response.value.books[1].book[0].@available

//xml节点遍历,找出李刚的所有书
def list = []
//对books节点进行遍历
response.value.books.each { books ->
    //对book节点进行遍历
    books.book.each { book ->
        //book节点内容
        def author = book.author.text()
        if (author.equals('李刚')) {
            list.add(book.title.text())
        }
    }
}
println "李刚的所有书: ${list.toListString()}"

//深度遍历xml数据
def titleList = response.depthFirst().findAll { book ->
    //book节点数据
    return book.author.text() == '李刚' ? true : false
}
println "深度遍历,李刚的所有书: ${titleList.toListString()}"

//广度遍历xml数据
def title = response.value.books.children().findAll { node ->
    //节点node,是book节点，并且id为2
    node.name() == 'book' && node.@id == '2'
}.collect { node ->
    return node.title.text()
}
println title


/***
 * 二、生成xml格式数据
 */
/**
 * <langs type='current' count='3' mainstream='true'>
 *   <language flavor='static' version='1.5'>java</language>
 *   <language flavor='dynamic' version='1.6.0'>Groovy</language>
 *   <language flavor='dynamic' version='1.9'>JavaScript</language>
 * </langs>
 */
//保存xml数据
def sw = new StringWriter()
//用来生成xml数据的核心类
def xmlBuilder = new MarkupBuilder(sw)

//1、静态生成xml数据
//创建根节点langs,指定节点的属性和值。通过伪方法添加节点数据
xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
    //第1个language节点,指定节点的属性和值
    language(flavor: 'static', version: '1.5') {
        //节点嵌套
        subject('java')
        age('15')
    }
    //第2个language节点,指定节点的属性和值
    language(flavor: 'dynamic', version: '1.6.0') {
        subject('Groovy')
        age('10')
    }
    //第3个language节点,指定节点的属性和值
    language(flavor: 'dynamic', version: '1.9', 'Gradle')
    //第4个language节点,指定节点的属性和值
    language(flavor: 'dynamic', version: '2.0', 'Python')
}

//打印xml数据
println sw


//2、动态生成xml数据
//对应于xml中的langs节点
class Langs {
    /**
     * lnags节点属性
     */
    String type = 'current'

    /**
     * 节点属性
     */
    int count = 3

    /**
     * 节点属性
     */
    boolean mainstream = true

    /**
     * languages节点
     */
    def languages = [new Language(flavor: 'static', version: '1.6', value: 'java'),
                     new Language(flavor: 'static', version: '1.7', value: 'C++'),
                     new Language(flavor: 'dynamic', version: '1.8', value: 'Groovy'),
                     new Language(flavor: 'dynamic', version: '1.9', value: 'Gradle'),
                     new Language(flavor: 'dynamic', version: '1.4', value: 'Python')
    ]
}

//对应于xml中的language节点
class Language {
    /**
     * 节点属性
     */
    String flavor

    /**
     * 节点属性
     */
    String version

    /**
     * 节点值
     */
    String value
}

//写入xml数据
def sw2 = new StringWriter()
//用来生成xml数据的核心类
def xmlMarkupBuilder = new MarkupBuilder()

//实体对象
def langs = new Langs()
//生成langs节点，节点属性
xmlMarkupBuilder.langs(type: langs.type, count: langs.count, mainstream: langs.mainstream) {
    //遍历所有的子节点
    langs.languages.each { lang ->
        //生成language节点
        language(flavor: lang.flavor, version: lang.version, lang.value)
    }
}

//打印xml数据
println sw2



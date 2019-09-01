package com.pandora.gtroovy.file

import groovy.util.slurpersupport.GPathResult

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



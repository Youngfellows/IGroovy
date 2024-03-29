package com.pandora.groovy.file

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.json.StringEscapeUtils
import com.pandora.groovy.bean.People

/**
 * 一、Groovy中JSON处理
 */
//将对象转化为JSON字符串
def list = [new People(name: '张山', age: 22, job: '送外卖'),
            new People(name: '杨过', age: 24, job: '司机'),
            new People(name: '小龙女', age: 24, job: '护士'),
            new People(name: '郭靖', age: 18, job: '保洁员')]

//1、将map转化为map
def jsonStr1 = JsonOutput.toJson(list)
println jsonStr1

//格式化json输出
def prettyJson = JsonOutput.prettyPrint(jsonStr1)
//处理JSON文本中的Unicode字符
prettyJson = StringEscapeUtils.unescapeJava(prettyJson)
println prettyJson


//2、将JSON数据转化为object实体对象
def jsonSlurper = new JsonSlurper()
List<People> persions = jsonSlurper.parseText(prettyJson)
println "${persions.toListString()}"

//遍历列表
for (int i = 0; i < persions.size(); i++) {
    def person = persions[i]
    println "${i},${person.name},${person.job},${person.age}"
}

//3.发起网络请求JSON数据
def getNetworkData(String url) {
    //发起HTTP网络请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    //获取请求结果
    def resopnse = connection.content.text
    println resopnse
    return resopnse
}

//获取版本信息
def url = 'https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/json/json.txt'
def versionJson = getNetworkData(url)

//将JSON数据转化为实体对象
def jsonSlurper1 = new JsonSlurper()
def resopnse = jsonSlurper1.parseText(versionJson)
//获取对象字段信息
println "change log:\r\n${resopnse.update_log}"
println "download path: ${resopnse.apk_file_url}"

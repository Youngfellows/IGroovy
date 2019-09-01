package com.pandora.groovy.file

import com.pandora.groovy.bean.Person

/**
 * 一、文本文件的读写操作
 */
println('\r\n=====================   一、文本文件的读写操作     =========================\r\n')
def filePath = '../../../../../IGroovy.iml'
//获取Groovy中file对象
def file = new File(filePath)

//遍历文件每一行
println('\r\n=====================   遍历文件每一行     =========================\r\n')
file.eachLine { line ->
    println line
}

println('\r\n======================  获取文件的全部内容   =========================\r\n')
//获取文件的全部内容
def result = file.getText()
println result

println('\r\n======================  获取文件的全部内容列表   =========================\r\n')
//获取文件的全部内容列表
def linesList = file.readLines()
linesList.each { line ->
    //打印文件列表每一行的内容
    println line
}


println('\r\n======================  读取文件的部分内容   =========================\r\n')
def readerBuffer = file.withReader { reader ->
    //创建存放100个字符的buffer
    char[] buffer = new char[100]
    //从reader中读取100个字符存入buffer
    reader.read(buffer)
    return buffer
}
println readerBuffer


println('\r\n======================  案例:文件拷贝  =========================\r\n')

/**
 * 文件拷贝的方法
 * @param sourcePath 源文件路径
 * @param destationPath 目标文件路径
 */
def copy(String sourcePath, String destationPath) {
    try {
        //源文件
        def sourceFile = new File(sourcePath)
        if (!sourceFile.exists()) {
            println "${sourcePath}文件不存在..."
            return
        }
        //首先创建目标文件
        def destFile = new File(destationPath)
        if (!destFile.exists()) {
            //文件不存在,先创建目标文件
            destFile.createNewFile()
        }
        //开始拷贝文件
        sourceFile.withReader { reader ->
            //获取全部文件内容行列表集合
            def lines = reader.readLines()
            //写文件
            destFile.withWriter('utf-8') { writer ->
                lines.each { line ->
                    //一行一行的写
                    writer.append(line + '\r\n')
                }
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

//源文件
def sourcePath = '../../../../../book.xml'
//目标文件
def destationPath = '../../../../../book2.xml'

//拷贝文件
copy(sourcePath, destationPath)


/**
 * 二、对象的读写操作
 */
println('\r\n======================  二、对象的读写操作  =========================\r\n')
//保存对象到文件
def saveObject(Object object, String path) {
    try {
        //首先创建目标文件
        def destFile = new File(path)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }
        //写入对象到文件
        destFile.withObjectOutputStream { out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

//从文件中读取对象
def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) {
            return null
        }
        //从文件中读对象
        file.withObjectInputStream { input ->
            obj = input.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}


//把对象写入文件
//def person = new Person('jack', 18,'doctor')
def path = '../../../../../person.bin'
//saveObject(person, path)

//读文件对象
def resultPerson = (Person) readObject(path)
println resultPerson.toString()




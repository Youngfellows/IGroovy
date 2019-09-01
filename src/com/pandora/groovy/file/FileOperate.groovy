package com.pandora.groovy.file

/**
 * 一、文件的操作
 */
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
    } catch (Exception e) {
        e.printStackTrace()
    }
}

//源文件
def sourcePath = '../../../../../book.xml'
//目标文件
def destationPath = '../../../../../book2.xml'

//拷贝文件
copy(sourcePath, destationPath)

